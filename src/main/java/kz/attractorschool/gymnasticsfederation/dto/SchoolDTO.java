package kz.attractorschool.gymnasticsfederation.dto;


import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.model.School;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDTO {
    private Integer id;

    @NotNull
    @Size(min = 10, message = "Введите полное название школы")
    private String name;

    @Column
    @NotNull
    private String director;

//      скорее всего, после создания будут заменены юзером
//    @NotNull
//    private User user;

    @NotNull
    @Email
    private String email;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    @Size(min = 10, message = "Введите полный адрес")
    private String address;

    @NotNull
    @NotBlank
    private String phone;

    @NotNull
    private Integer federationId;

    @ManyToOne
    private FederationDTO federation;

    private boolean isDel;
//    @OneToMany
//    private List<Athlete> athletes;
//
//    @OneToMany
//    private List<Coach> coaches;

    public static SchoolDTO from(School school){
        return SchoolDTO.builder()
                .id(school.getId())
                .name(school.getName())
                .director(school.getDirector())
                .address(school.getAddress())
                .email(school.getEmail())
                .password(school.getPassword())
                .phone(school.getPhone())
                .federation(FederationDTO.from(school.getFederation()))
                .isDel(school.isDel())
                .build();
    }
}
