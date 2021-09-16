package kz.attractorschool.gymnasticsfederation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDisciplineProgramAddDTO {

    private Integer id;

    @NotNull
    private Integer competitionId;

    private Integer disciplineTypeId;

    private Integer competitionProgramId;
}
