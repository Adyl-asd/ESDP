package kz.attractorschool.gymnasticsfederation.dto;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.files.PersonPhoto;
import kz.attractorschool.gymnasticsfederation.model.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Integer id;

    @org.hibernate.validator.constraints.NotBlank
    @Size(min = 1, message = "Минимальная длина фамилии - один символ")
    private String surname;

    @org.hibernate.validator.constraints.NotBlank
    @Size(min = 2, message = "Минимальная длина имени - два символа")
    private String name;

    private String middleName;

    private PersonPhoto photo;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotNull
    @Size(min = 12, max = 12, message = "Длина ИИН - 12 символов")
    private String iin;

    @NotNull
    private String gender;

    @NotNull
    @org.hibernate.validator.constraints.NotBlank
    @Size(min = 2, message = "Слишком короткое имя города")
    private String city;

    @NotNull
    @org.hibernate.validator.constraints.NotBlank
    @Size(min = 10, message = "Вы ввели слишком короткий адрес")
    private String address;

    @NotNull
//    @Pattern(regexp = '\+?[0-9\s\-\(\)]+')
    private String phone;

    @NotNull
    @org.hibernate.validator.constraints.Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 10, message = "Слишком короткий ввод, введите полное название")
    private String education;

    private String comment;

    public static PersonDTO from(Person person){
        return PersonDTO.builder()
                .id(person.getId())
                .surname(person.getSurname())
                .name(person.getName())
                .middleName(person.getMiddleName())
                .photo(person.getPhoto())
                .birthday(person.getBirthday())
                .iin(person.getIin())
                .gender(person.getGender())
                .city(person.getCity())
                .address(person.getAddress())
                .phone(person.getPhone())
                .email(person.getEmail())
                .education(person.getEducation())
                .comment(person.getComment())
                .build();
    }
}
