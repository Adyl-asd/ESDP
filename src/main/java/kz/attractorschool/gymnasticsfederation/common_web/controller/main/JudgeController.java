package kz.attractorschool.gymnasticsfederation.common_web.controller.main;

import kz.attractorschool.gymnasticsfederation.dto.*;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.exception.StorageException;
import kz.attractorschool.gymnasticsfederation.common_data.entity.files.*;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Judge;
import kz.attractorschool.gymnasticsfederation.common_service.*;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/judge")
public class JudgeController {
    private final JudgeService service;
    private final SchoolService schoolService;
    private final JudgeCategoryService categoryService;
    private final DisciplineService disciplineService;
    private final PersonService personService;
    private final FileSystemStorageService fileSystemStorageService;
    private final StorageService storageService;

    @GetMapping("/all")
    public String all(Model model){
        List<Judge> judges = service.all();
        model.addAttribute("judges", judges);
        model.addAttribute("disciplines", disciplineService.all());
        model.addAttribute("categories", categoryService.all());
        return "judge/judges";
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("schools", schoolService.all());
        model.addAttribute("categories", categoryService.all());
        model.addAttribute("disciplines", disciplineService.all());
        model.addAttribute("persons", personService.all());
        return "judge/judge_add";
    }

    @PostMapping
    public String add(@Valid JudgeAddDTO judgeAddDTO,
                      BindingResult result,
                      RedirectAttributes attributes,
                      @RequestParam("dopingFile")MultipartFile dopingFile,
                      @RequestParam("categoryFile")MultipartFile categoryFile){
        attributes.addFlashAttribute("judgeDTO", judgeAddDTO);
//        if (result.hasFieldErrors()){
//            attributes.addFlashAttribute("errors", result.getFieldErrors());
//            return "redirect:/judge";
//        }
        if (!service.isPdf(dopingFile) || !service.isPdf(categoryFile)){
            attributes.addFlashAttribute("filesError", "?????? ?????????? ???????????? ???????? ?? ?????????????? PDF");
            return "redirect:/judge";
        }
        DopingFile doping = new DopingFile(dopingFile.getOriginalFilename());
        fileSystemStorageService.store(dopingFile);
        JudgeCategoryFile category = new JudgeCategoryFile(categoryFile.getOriginalFilename());
        fileSystemStorageService.store(categoryFile);
        JudgeDTO dto = service.add(judgeAddDTO, category, doping);
        return "redirect:/judge/" + dto.getId();
    }

    @GetMapping("/{id}")
    public String one(@PathVariable Integer id, Model model){
        JudgeDTO judgeDTO = service.getOne(id);
        model.addAttribute("judge", judgeDTO);
        return "judge/judge";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/judge/all";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("judge", service.getOne(id));
        model.addAttribute("schools", schoolService.all());
        model.addAttribute("categories", categoryService.all());
        model.addAttribute("disciplines", disciplineService.all());
        model.addAttribute("persons", personService.all());
        model.addAttribute("judge", service.findOne(id));
        return "judge/judge_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         @Valid JudgeUpdateDTO judgeUpdateDTO,
                         BindingResult result,
                         RedirectAttributes attributes,
                         @RequestParam("categoryFile")MultipartFile categoryFile){
        attributes.addFlashAttribute("judgeDTO", judgeUpdateDTO);
        if (categoryFile != null && !categoryFile.isEmpty()){
            if (!service.isPdf(categoryFile)){
                attributes.addFlashAttribute("filesError", "?????? ?????????? ???????????? ???????? ?? ?????????????? PDF");
                return "redirect:/judge/" + id + "/update";
            }
            JudgeCategoryFile category = new JudgeCategoryFile(categoryFile.getOriginalFilename());
            fileSystemStorageService.store(categoryFile);
            service.updateFile(id, category);
        }

        JudgeDTO dto = service.update(id, judgeUpdateDTO);
        return "redirect:/judge/" + dto.getId();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "exception/resource-not-found";
    }

    @ExceptionHandler(StorageException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private String handleRNF(StorageException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("cause", ex.getCause());
        return "exception/empty_file";
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<Resource> getFilePic(@PathVariable String filename) {
        {
            Resource file = storageService.loadAsResource(filename);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + file.getFilename() + "\"")
                    .body(file);
        }
    }
}
