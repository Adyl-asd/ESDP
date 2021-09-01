package kz.attractorschool.gymnasticsfederation.controller;


import kz.attractorschool.gymnasticsfederation.dto.AthleteAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.AthleteDTO;
import kz.attractorschool.gymnasticsfederation.dto.AthleteUpdateDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.exception.StorageException;
import kz.attractorschool.gymnasticsfederation.files.DopingFile;
import kz.attractorschool.gymnasticsfederation.files.MedicalFile;
import kz.attractorschool.gymnasticsfederation.files.RankFile;
import kz.attractorschool.gymnasticsfederation.files.RegistryFile;
import kz.attractorschool.gymnasticsfederation.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/athlete")
public class AthleteController {
    private final AthleteService service;
    private final SchoolService schoolService;
    private final RankService rankService;
    private final DisciplineService disciplineService;
    private final PersonService personService;
    private final FileSystemStorageService fileSystemStorageService;

    @GetMapping
    public String add(Model model){
        model.addAttribute("schools", schoolService.all());
        model.addAttribute("ranks", rankService.all());
        model.addAttribute("disciplines", disciplineService.all());
        model.addAttribute("persons", personService.all());
        return "athlete/athlete_add";
    }

    @PostMapping
    public String add(@Valid AthleteAddDTO athleteDTO,
                      BindingResult result,
                      RedirectAttributes attributes,
                      @RequestParam("registryFile")MultipartFile registryFile,
                      @RequestParam("medicalFile")MultipartFile medicalFile,
                      @RequestParam("dopingFile")MultipartFile dopingFile,
                      @RequestParam("rankFile")MultipartFile rankFile){
        attributes.addFlashAttribute("athleteDTO", athleteDTO);
//        if (result.hasFieldErrors()){
//            attributes.addFlashAttribute("errors", result.getFieldErrors());
//            return "redirect:/athlete";
//        }
        RegistryFile registry = new RegistryFile(registryFile.getOriginalFilename());
        fileSystemStorageService.store(registryFile);
        MedicalFile medical = new MedicalFile(medicalFile.getOriginalFilename());
        fileSystemStorageService.store(medicalFile);
        DopingFile doping = new DopingFile(dopingFile.getOriginalFilename());
        fileSystemStorageService.store(dopingFile);
        RankFile rank = new RankFile(rankFile.getOriginalFilename());
        fileSystemStorageService.store(rankFile);
        AthleteDTO dto = service.add(athleteDTO, registry, medical, rank, doping);
        return "redirect:/athlete/" + dto.getId();
    }

    @GetMapping("/{id}")
    public String one(@PathVariable Integer id, Model model){
        model.addAttribute("athlete", service.getOne(id));
        return "athlete/athlete";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/athlete";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("schools", schoolService.all());
        model.addAttribute("ranks", rankService.all());
        model.addAttribute("disciplines", disciplineService.all());
        model.addAttribute("persons", personService.all());
        model.addAttribute("athlete", service.findOne(id));
        return "athlete/athlete_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         @Valid AthleteUpdateDTO athleteDTO,
                         BindingResult result,
                         RedirectAttributes attributes,
                         @RequestParam("registryFile")MultipartFile registryFile,
                         @RequestParam("medicalFile")MultipartFile medicalFile,
                         @RequestParam("dopingFile")MultipartFile dopingFile,
                         @RequestParam("rankFile")MultipartFile rankFile){
        attributes.addFlashAttribute("athleteDTO", athleteDTO);
//        if (result.hasFieldErrors()){
//            attributes.addFlashAttribute("errors", result.getFieldErrors());
//            return "redirect:/athlete/" + id + "/update";
//        }
        if (registryFile != null && !registryFile.isEmpty()) {
            RegistryFile registry = new RegistryFile(registryFile.getOriginalFilename());
            fileSystemStorageService.store(registryFile);
            service.updateFile(id, registry);
        }
        else if(medicalFile != null && !medicalFile.isEmpty()){
            MedicalFile medical = new MedicalFile(medicalFile.getOriginalFilename());
            fileSystemStorageService.store(medicalFile);
            service.updateFile(id, medical);
        }
        else if(dopingFile != null && !dopingFile.isEmpty()){
            DopingFile doping = new DopingFile(dopingFile.getOriginalFilename());
            fileSystemStorageService.store(dopingFile);
            service.updateFile(id, doping);
        }
        else if (rankFile != null && !rankFile.isEmpty()){
            RankFile rank = new RankFile(rankFile.getOriginalFilename());
            fileSystemStorageService.store(rankFile);
            service.updateFile(id, rank);
        }
        AthleteDTO dto = service.update(id, athleteDTO);
        return "redirect:/athlete/" + dto.getId();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "resource-not-found";
    }

    @ExceptionHandler(StorageException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private String handleRNF(StorageException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("cause", ex.getCause());
        return "empty_file";
    }
}
