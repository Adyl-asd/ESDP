package kz.attractorschool.gymnasticsfederation.common_service;

//import kz.attractorschool.gymnasticsfederation.common_data.entity.QPerson;
import kz.attractorschool.gymnasticsfederation.dto.PersonDTO;
import kz.attractorschool.gymnasticsfederation.dto.PersonFilter;
//import kz.attractorschool.gymnasticsfederation.dto.search.PersonSearchDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_data.entity.files.PersonPhoto;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Person;
import kz.attractorschool.gymnasticsfederation.common_data.repository.PersonPhotoRepository;
import kz.attractorschool.gymnasticsfederation.common_data.repository.PersonRepository;
import kz.attractorschool.gymnasticsfederation.common_data.specification.ModelSpecification;
import kz.attractorschool.gymnasticsfederation.common_data.specification.SearchModel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository repository;
    private final PersonPhotoRepository personPhotoRepository;
    private final ModelSpecification<Person, PersonFilter> specification;

    public Person findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Персона", id);
        });
    }

    public PersonDTO getOne(Integer id){
        return PersonDTO.from(findOne(id));
    }

    public PersonDTO addTest(PersonPhoto personPhoto, PersonDTO personDTO) {
        Person person = Person.builder()
                .surname(personDTO.getSurname())
                .name(personDTO.getName())
                .middleName(personDTO.getMiddleName())
                .photo(personPhoto)
                .birthday(personDTO.getBirthday())
                .iin(personDTO.getIin())
                .gender(personDTO.getGender())
                .city(personDTO.getCity())
                .address(personDTO.getAddress())
                .phone(personDTO.getPhone())
                .email(personDTO.getEmail())
                .education(personDTO.getEducation())
                .comment(personDTO.getComment())
                .build();
        System.out.println("ok");
        return PersonDTO.from(person);
    }

    public PersonDTO add(PersonPhoto personPhoto, PersonDTO personDTO){
        PersonPhoto photo = personPhotoRepository.save(personPhoto);
        Person person = repository.save(Person.builder()
                .surname(personDTO.getSurname())
                .name(personDTO.getName())
                .middleName(personDTO.getMiddleName())
                .photo(photo)
                .birthday(personDTO.getBirthday())
                .iin(personDTO.getIin())
                .gender(personDTO.getGender())
                .city(personDTO.getCity())
                .address(personDTO.getAddress())
                .phone(personDTO.getPhone())
                .email(personDTO.getEmail())
                .education(personDTO.getEducation())
                .comment(personDTO.getComment())
                .build());
        return PersonDTO.from(person);
    }

    public String delete(Integer id){
        Person person = findOne(id);
        person.setDel(true);
        repository.save(person);
        return "ok";
    }

    public PersonDTO update(PersonDTO personDTO, Integer id){
        Person person = findOne(id);
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setMiddleName(personDTO.getMiddleName());
        person.setAddress(person.getAddress());
        person.setBirthday(person.getBirthday());
        person.setCity(personDTO.getCity());
        person.setComment(personDTO.getComment());
        person.setEducation(personDTO.getEducation());
        person.setEmail(personDTO.getEmail());
        person.setGender(personDTO.getGender());
        person.setPhone(person.getPhone());
        repository.save(person);
        return PersonDTO.from(person);
    }

    public PersonDTO updatePhoto(PersonPhoto personPhoto, Integer id){
        Person person = findOne(id);
        PersonPhoto photo = personPhotoRepository.save(personPhoto);
        person.setPhoto(photo);
        repository.save(person);
        return PersonDTO.from(person);
    }

    public List<Person> all(){
        return repository.findAll();
    }

    public boolean isUnique(String iin){
        return repository.existsByIin(iin);
    }

//    public List<Person> search(PersonSearchDTO dto){
//        List<Person> all = repository.findAll();
//        return all.stream().filter(p -> p.getCity().toUpperCase().contains(dto.getCity().toUpperCase()))
////                .filter(p -> p.getIin().contains(dto.getIin()))
//                .filter(p -> p.getName().contains(dto.getName()))
////                .filter(p -> p.getSurname().contains(dto.getSurname()))
//                .collect(Collectors.toList());
//    }

//    public  Page<Person> search(SearchModel<PersonFilter> searchModel){
//
//        Specification<Person> specification = this.specification.createSpecification(searchModel.getFilter(), searchModel.getSort());
//        return repository.findAll(specification, searchModel.getPagination().getPageRequest());
//    }


//    public Iterable search(PersonSearchDTO dto){
//        QPerson person = QPerson.person;
//        if (!isNull(dto.getName())){
//            if (isNull(dto.getSurname()) && isNull(dto.getIin()) && isNull(dto.getCity())){
//                return repository.findAll(person.name.toUpperCase().contains(dto.getName().toUpperCase()));
//            }
//            else if(isNull(dto.getCity()) && isNull(dto.getIin())){
//                return repository.findAll(person.name.toUpperCase().contains(dto.getName().toUpperCase())
//                        .andAnyOf(person.surname.toUpperCase().contains(dto.getSurname().toUpperCase())));
//            }
//            else if(isNull(dto.getIin())){
//                return repository.findAll(person.name.toUpperCase().contains(dto.getName().toUpperCase())
//                        .andAnyOf(person.surname.toUpperCase().contains(dto.getSurname().toUpperCase())
//                                .andAnyOf(person.city.toUpperCase().contains(dto.getCity().toUpperCase()))));
//            }
//        }
//
//        else if(isNull(dto.getName()) && isNull(dto.getIin()) && isNull(dto.getCity())){
//            return repository.findAll(person.surname.toUpperCase().contains(dto.getSurname().toUpperCase()));
//        }
//        else if(isNull(dto.getName()) && isNull(dto.getSurname()) && isNull(dto.getCity())){
//            return repository.findAll(person.iin.toUpperCase().contains(dto.getIin().toUpperCase()));
//        }
//        else if(isNull(dto.getName()) && isNull(dto.getSurname()) && isNull(dto.getIin())){
//            return repository.findAll(person.city.toUpperCase().contains(dto.getCity().toUpperCase()));
//        }
//        else if(isNull(dto.getName()) && isNull(dto.getSurname()) && isNull(dto.getIin()) && isNull(dto.getCity())){
//            return repository.findAll(person.name.toUpperCase().contains(dto.getName().toUpperCase())
//                    .andAnyOf(person.surname.toUpperCase().contains(dto.getSurname().toUpperCase())
//                            .andAnyOf(person.city.toUpperCase().contains(dto.getCity().toUpperCase())))
//                    .andAnyOf(person.iin.toUpperCase().contains(dto.getIin().toUpperCase())));
//        }
//        return repository.findAll(person.name.contains(dto.getName()).andAnyOf(person.surname.contains(dto.getSurname())
//                .andAnyOf(person.iin.contains(dto.getIin()).andAnyOf(person.city.contains(dto.getCity())))));
//
//    }

    private boolean isNull(String predicate){
        return predicate == null;
    }

    private String toUpper(String str){
        return str.toUpperCase();
    }
}
