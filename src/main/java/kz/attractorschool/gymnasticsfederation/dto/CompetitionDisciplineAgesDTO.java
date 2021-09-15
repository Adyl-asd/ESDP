package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplineAges;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDisciplineAgesDTO {

    @NotNull
    private Integer id;

    private CompetitionDTO competition;

    private DisciplineTypeDTO disciplineType;

    private AgeCategoryDTO ageCategory;

    public static CompetitionDisciplineAgesDTO from(CompetitionDisciplineAges competitionDisciplines) {
        return builder()
                .id(competitionDisciplines.getId())
                .competition(CompetitionDTO.from(competitionDisciplines.getCompetition()))
                .disciplineType(DisciplineTypeDTO.from(competitionDisciplines.getDiscipline()))
                .ageCategory(AgeCategoryDTO.from(competitionDisciplines.getAgeCategory()))
                .build();
    }
}
