package kz.attractorschool.gymnasticsfederation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class CompetitionProgramAddDTO {
    @NotNull
    @Min(value = 1, message = "Выберите дисциплину")
    private int disciplineTypeId;

    @NotNull
    @Size(min = 2, message = "Слишком короткое название")
    private String name;
}
