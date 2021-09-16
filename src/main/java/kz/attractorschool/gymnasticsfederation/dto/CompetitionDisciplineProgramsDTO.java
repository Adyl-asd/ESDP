package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplinePrograms;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDisciplineProgramsDTO {
    @NotNull
    private Integer id;

    private CompetitionDTO competition;

    private DisciplineTypeDTO disciplineType;

    private CompetitionProgramDTO competitionProgram;

    public static CompetitionDisciplineProgramsDTO from(CompetitionDisciplinePrograms competitionDisciplines) {
        return builder()
                .id(competitionDisciplines.getId())
                .competition(CompetitionDTO.from(competitionDisciplines.getCompetition()))
                .disciplineType(DisciplineTypeDTO.from(competitionDisciplines.getDiscipline()))
                .competitionProgram(CompetitionProgramDTO.from(competitionDisciplines.getCompetitionProgram()))
                .build();
    }
}
