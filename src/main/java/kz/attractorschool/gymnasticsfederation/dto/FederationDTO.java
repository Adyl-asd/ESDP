package kz.attractorschool.gymnasticsfederation.dto;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.model.Federation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FederationDTO {
    private Integer id;

    @Size(min = 5, message = "Ведите полное название федерации")
    @NotNull
    private String name;

    @NotNull
    @Size(min = 7, message = "Ведите ФИО директора")
    private String director;

    //      скорее всего, после создания будут заменены юзером
//    @NotNull
//    private User user;

    @Email
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    private String password;

    @Size(min = 10, message = "Введите полный адрес")
    @NotNull
    private String address;

    @NotBlank
    @NotNull
    private String phone;

    public static FederationDTO from(Federation federation){
        return FederationDTO.builder()
                .id(federation.getId())
                .name(federation.getName())
                .director(federation.getDirector())
                .address(federation.getAddress())
                .email(federation.getEmail())
                .password(federation.getPassword())
                .phone(federation.getPhone())
                .build();
    }
}
