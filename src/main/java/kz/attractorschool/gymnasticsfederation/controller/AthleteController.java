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
import kz.attractorschool.gymnasticsfederation.dto.AthleteRegisterDTO;
import kz.attractorschool.gymnasticsfederation.model.Athlete;
import kz.attractorschool.gymnasticsfederation.model.Person;
import kz.attractorschool.gymnasticsfederation.pdf_exporter.AthletePdfExporter;
import kz.attractorschool.gymnasticsfederation.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private final CoachService coachService;


    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("athletes", service.all());
        return "athlete/all";
    }

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
        if (result.hasFieldErrors()){
            attributes.addFlashAttribute("errors", result.getFieldErrors());
            return "redirect:/athlete";
        }
        if (!service.isPdf(registryFile) || !service.isPdf(medicalFile) ||
        !service.isPdf(dopingFile) || !service.isPdf(rankFile)){
            attributes.addFlashAttribute("filesError", "Все файлы должны быть в формате PDF");
            return "redirect:/athlete";
        }
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
        AthleteDTO athleteDTO = service.checkStatus(service.findOne(id));
        model.addAttribute("athlete", athleteDTO);
        model.addAttribute("coaches", service.universalCoaches(athleteDTO));
//        model.addAttribute("dates", service.coachesHistory(id));
        return "athlete/athlete";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/athlete";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("athlete", service.getOne(id));
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
        if (result.hasFieldErrors()){
            attributes.addFlashAttribute("errors", result.getFieldErrors());
            return "redirect:/athlete/" + id + "/update";
        }
        if (registryFile != null && !registryFile.isEmpty()) {
            if (!service.isPdf(registryFile)){
                attributes.addFlashAttribute("filesError", "Все файлы должны быть в формате PDF");
                return "redirect:/athlete";
            }
            RegistryFile registry = new RegistryFile(registryFile.getOriginalFilename());
            fileSystemStorageService.store(registryFile);
            service.updateFile(id, registry);
        }
        else if(medicalFile != null && !medicalFile.isEmpty()){
            if (!service.isPdf(medicalFile)){
                attributes.addFlashAttribute("filesError", "Все файлы должны быть в формате PDF");
                return "redirect:/athlete";
            }
            MedicalFile medical = new MedicalFile(medicalFile.getOriginalFilename());
            fileSystemStorageService.store(medicalFile);
            service.updateFile(id, medical);
        }
        else if(dopingFile != null && !dopingFile.isEmpty()){
            if (!service.isPdf(dopingFile)){
                attributes.addFlashAttribute("filesError", "Все файлы должны быть в формате PDF");
                return "redirect:/athlete";
            }
            DopingFile doping = new DopingFile(dopingFile.getOriginalFilename());
            fileSystemStorageService.store(dopingFile);
            service.updateFile(id, doping);
        }
        else if (rankFile != null && !rankFile.isEmpty()){
            if (!service.isPdf(rankFile)){
                attributes.addFlashAttribute("filesError", "Все файлы должны быть в формате PDF");
                return "redirect:/athlete";
            }
            RankFile rank = new RankFile(rankFile.getOriginalFilename());
            fileSystemStorageService.store(rankFile);
            service.updateFile(id, rank);
        }

        AthleteDTO dto = service.update(id, athleteDTO);
        return "redirect:/athlete/" + dto.getId();
    }

    @PostMapping("/{id}/confirm")
    public String confirm(@PathVariable Integer id){
        service.confirm(id);
        return "redirect:/athlete/" + id;
    }

    @GetMapping("/{id}/register")
    public String register(@PathVariable Integer id, Model model){
        model.addAttribute("athlete", service.getOne(id));
        model.addAttribute("schools", schoolService.all());
        model.addAttribute("ranks", rankService.all());
        return "athlete/register";
    }

    @PostMapping("/{id}/register")
    public String register(@PathVariable Integer id, @Valid AthleteRegisterDTO athleteDTO,
                           @RequestParam("medicalFile")MultipartFile medicalFile,
                           @RequestParam("dopingFile")MultipartFile dopingFile,
                           @RequestParam("rankFile")MultipartFile rankFile,
                           BindingResult result, RedirectAttributes attributes){
        attributes.addFlashAttribute("athleteDTO", athleteDTO);
        if (result.hasFieldErrors()){
            attributes.addFlashAttribute("errors", result.getFieldErrors());
            return "redirect:/athlete";
        }
        if (!service.isPdf(medicalFile) || !service.isPdf(dopingFile) || !service.isPdf(rankFile)){
            attributes.addFlashAttribute("filesError", "Все файлы должны быть в формате PDF");
            return "redirect:/athlete/" + id + "/register";
        }
        MedicalFile medical = new MedicalFile(medicalFile.getOriginalFilename());
        fileSystemStorageService.store(medicalFile);
        DopingFile doping = new DopingFile(dopingFile.getOriginalFilename());
        fileSystemStorageService.store(dopingFile);
        RankFile rank = new RankFile(rankFile.getOriginalFilename());
        fileSystemStorageService.store(rankFile);
        AthleteDTO dto = service.register(id, athleteDTO, medical, rank, doping);
        return "redirect:/athlete/" + id;
    }

    @GetMapping("/{id}/coach")
    public String addCoach(@PathVariable Integer id, Model model){
        AthleteDTO athleteDTO = service.getOne(id);
        model.addAttribute("athlete", athleteDTO);
        model.addAttribute("coaches", service.universalCoaches(athleteDTO));
        return "athlete/add_coach";
    }

    @PostMapping("/{id}/coach")
    public String addCoach(@PathVariable Integer id, @RequestParam Integer coachId){
        service.addCoach(id, coachId);
        return "redirect:/athlete/" + id;
    }

    @PostMapping("/{id}/coach/{coachId}/delete")
    public String deleteCoach(@PathVariable Integer id, @PathVariable Integer coachId){
        AthleteDTO athleteDTO = service.deleteCoach(id, coachId);
        return "redirect:/athlete/" + id;
    }

    @GetMapping("/{id}/export")
    public void toPdf(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=person_" + currentDateTime + ".pdf";

        response.setHeader(headerKey, headerValue);

        Athlete athlete = service.findOne(id);

        AthletePdfExporter exporter = new AthletePdfExporter(athlete);
        exporter.export(response);
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
}
