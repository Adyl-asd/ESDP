package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplines;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDisciplinesDTO {

    @NotNull
    private Integer id;

    private CompetitionDTO competition;

    private DisciplineTypeDTO disciplineType;

    private AgeCategoryDTO ageCategory;

    private CompetitionProgramDTO competitionProgram;

    public static CompetitionDisciplinesDTO from(CompetitionDisciplines competitionDisciplines) {
        return builder()
                .id(competitionDisciplines.getId())
                .competition(CompetitionDTO.from(competitionDisciplines.getCompetition()))
                .disciplineType(DisciplineTypeDTO.from(competitionDisciplines.getDisciplineType()))
                .ageCategory(AgeCategoryDTO.from(competitionDisciplines.getAgeCategory()))
                .competitionProgram(CompetitionProgramDTO.from(competitionDisciplines.getCompetitionProgram()))
                .build();
    }
}
