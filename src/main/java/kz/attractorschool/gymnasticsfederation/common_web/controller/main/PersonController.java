package kz.attractorschool.gymnasticsfederation.common_web.controller.main;

import kz.attractorschool.gymnasticsfederation.common_data.specification.SearchModel;
import kz.attractorschool.gymnasticsfederation.dto.PersonDTO;
import kz.attractorschool.gymnasticsfederation.dto.PersonFilter;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_data.entity.files.PersonPhoto;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Person;
import kz.attractorschool.gymnasticsfederation.common_service.FileSystemStorageService;
import kz.attractorschool.gymnasticsfederation.common_service.PersonService;
import kz.attractorschool.gymnasticsfederation.common_service.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final PersonService service;
    private final FileSystemStorageService fileSystemStorageService;
    private final StorageService storageService;
    List<PersonDTO> personDTOS;

    @GetMapping
    public String add() {
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
        } else if (!service.isUnique(personDTO.getIin())) {
            attributes.addFlashAttribute("iinError", "Пользователь с ИИН " + personDTO.getIin() + " уже существует");
        }
        PersonPhoto newFile = new PersonPhoto(file.getOriginalFilename());
        fileSystemStorageService.store(file);
        PersonDTO dto = service.add(newFile, personDTO);
        return "redirect:/person/" + dto.getId();
    }

    @GetMapping("/all")
    public String persons(Model model){
        if (personDTOS.size() == 0){
            model.addAttribute("persons", service.all());
        }
        else{
            model.addAttribute("persons", personDTOS);
        }
        return "person/all";
    }

    @GetMapping("/{id}")
    public String one(@PathVariable Integer id, Model model) {
        Person person = service.findOne(id);
        model.addAttribute("person", service.getOne(id));
        model.addAttribute("athletes", person.getAthletes());
        model.addAttribute("coaches", person.getCoaches());
        model.addAttribute("judges", person.getJudges());
        return "person/person";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/person";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("person", service.getOne(id));
        return "person/person_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         @Valid PersonDTO personDTO,
                         @RequestParam("file") MultipartFile file,
                         BindingResult validationResult,
                         RedirectAttributes attributes) {
        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/person/" + id + "/update";
        }
        if (file != null && !file.isEmpty()) {
            PersonPhoto newFile = new PersonPhoto(file.getOriginalFilename());
            fileSystemStorageService.store(file);
            service.updatePhoto(newFile, id);
        }
        service.update(personDTO, id);
        return "redirect:/person/" + id;
    }

    @PostMapping("/persons")
    public String all() {
        List<Person> persons = service.all();
        List<PersonDTO> models = persons.stream().map(PersonDTO::from).collect(Collectors.toList());
        personDTOS = models;
        return "redirect:/person/all";
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
