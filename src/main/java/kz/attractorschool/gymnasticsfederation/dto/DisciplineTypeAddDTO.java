package kz.attractorschool.gymnasticsfederation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
public class DisciplineTypeAddDTO {
    @NotNull
    @Size(min = 1, message = "Слишком короткое имя")
    private String name;

    @NotNull
    private Integer disciplineId;
    private Integer participantsAmountMin;
    private Integer participantsAmountMax;

    @NotNull
    private String gender;
}
