package kz.attractorschool.gymnasticsfederation.controller;

import kz.attractorschool.gymnasticsfederation.dto.PersonDTO;
import kz.attractorschool.gymnasticsfederation.dto.PersonSearchDTO;
import kz.attractorschool.gymnasticsfederation.pdf_exporter.AthletePdfExporter;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.files.PersonPhoto;
import kz.attractorschool.gymnasticsfederation.model.Person;
import kz.attractorschool.gymnasticsfederation.service.FileSystemStorageService;
import kz.attractorschool.gymnasticsfederation.service.PersonService;
import kz.attractorschool.gymnasticsfederation.service.StorageService;
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

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final PersonService service;
    private final FileSystemStorageService fileSystemStorageService;
    private final StorageService storageService;

    @GetMapping
    public String add(){
        return "person/add_person";
    }

    @PostMapping
    public String add(@Valid PersonDTO personDTO,
                      BindingResult validationResult,
                      RedirectAttributes attributes,
                      @RequestParam("file") MultipartFile file) {
        attributes.addFlashAttribute("personDTO", personDTO);
        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/person";
        }
        else if(!service.isUnique(personDTO.getIin())){
            attributes.addFlashAttribute("iinError", "Пользователь с ИИН " + personDTO.getIin() + " уже существует");
        }
        PersonPhoto newFile = new PersonPhoto(file.getOriginalFilename());
        fileSystemStorageService.store(file);
        PersonDTO dto = service.add(newFile, personDTO);
        return "redirect:/person/" + dto.getId();
    }

    @GetMapping("/all")
    public String all(PersonSearchDTO dto, Model model){
        model.addAttribute("persons", service.search(dto));
        return "person/all";
    }

    @GetMapping("/{id}")
    public String one(@PathVariable Integer id, Model model){
        Person person = service.findOne(id);
        model.addAttribute("person", service.getOne(id));
        model.addAttribute("athletes", person.getAthletes());
        model.addAttribute("coaches", person.getCoaches());
        model.addAttribute("judges", person.getJudges());
        return "person/person";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/person";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("person", service.getOne(id));
        return "person/person_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         @Valid PersonDTO personDTO,
                         @RequestParam("file") MultipartFile file,
                         BindingResult validationResult,
                         RedirectAttributes attributes){
        if (validationResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/person/" + id + "/update";
        }
        if (file != null && !file.isEmpty()) {
            PersonPhoto newFile = new PersonPhoto(file.getOriginalFilename());
            fileSystemStorageService.store(file);
            service.updatePhoto(newFile, id);
        }
        service.update(personDTO, id);
        return "redirect:/person/" + id ;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "exception/resource-not-found";
    }

    @GetMapping("/photo/{filename:.+}")
    public ResponseEntity<Resource> getFilePic(@PathVariable String filename) {
        {
            Resource file = storageService.loadAsResource(filename);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + file.getFilename() + "\"")
                    .body(file);
        }
    }
}
