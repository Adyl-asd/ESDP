package kz.attractorschool.gymnasticsfederation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AgeCategoryAddDTO {
    private Integer minYear;
    private Integer maxYear;

    @NotNull
    private Integer disciplineId;
    private Integer rankId;
}
