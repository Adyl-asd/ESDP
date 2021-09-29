package kz.attractorschool.gymnasticsfederation.common_web.controller.api;

import kz.attractorschool.gymnasticsfederation.dto.PersonDTO;
import kz.attractorschool.gymnasticsfederation.dto.PersonFilter;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Person;
import kz.attractorschool.gymnasticsfederation.common_service.PersonService;
import kz.attractorschool.gymnasticsfederation.common_data.specification.SearchModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/filter")
@RequiredArgsConstructor
public class FilterController {

    private final PersonService personService;

    @PostMapping("/persons")
    public Page<PersonDTO> all(@RequestBody SearchModel<PersonFilter> searchModel) {
        Page<Person> persons = personService.search(searchModel);
        List<PersonDTO> models = persons.stream().map(PersonDTO::from).collect(Collectors.toList());
        return new PageImpl<>(models, persons.getPageable(), persons.getTotalElements());
    }
}
