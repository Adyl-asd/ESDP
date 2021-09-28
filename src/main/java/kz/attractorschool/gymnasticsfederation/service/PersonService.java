package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.PersonDTO;
import kz.attractorschool.gymnasticsfederation.dto.PersonSearchDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.files.PersonPhoto;
import kz.attractorschool.gymnasticsfederation.model.Person;
import kz.attractorschool.gymnasticsfederation.model.QPerson;
import kz.attractorschool.gymnasticsfederation.repository.PersonPhotoRepository;
import kz.attractorschool.gymnasticsfederation.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository repository;
    private final PersonPhotoRepository personPhotoRepository;

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

    public Iterable search(PersonSearchDTO dto){
        QPerson person = QPerson.person;
        return repository.findAll(person.name.contains(dto.getName()).andAnyOf(person.surname.contains(dto.getSurname())
                .andAnyOf(person.iin.contains(dto.getIin()).andAnyOf(person.city.contains(dto.getCity())))));

    }
}
