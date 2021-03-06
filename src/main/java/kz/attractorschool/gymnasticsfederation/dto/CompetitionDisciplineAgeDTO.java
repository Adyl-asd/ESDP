package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.common_data.entity.CompetitionDisciplineAge;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDisciplineAgeDTO {

    @NotNull
    private Integer id;

    private int teamChampionship;

    private CompetitionDTO competition;

    private DisciplineTypeDTO disciplineType;

    private AgeCategoryDTO ageCategory;

    private Integer maxTeams;

    private Integer maxAthletes;

    public static CompetitionDisciplineAgeDTO from(CompetitionDisciplineAge competitionDisciplines) {
        return builder()
                .id(competitionDisciplines.getId())
                .competition(CompetitionDTO.from(competitionDisciplines.getCompetition()))
                .disciplineType(DisciplineTypeDTO.from(competitionDisciplines.getDiscipline()))
                .ageCategory(AgeCategoryDTO.from(competitionDisciplines.getAgeCategory()))
                .maxTeams(competitionDisciplines.getMaxTeams())
                .maxAthletes(competitionDisciplines.getMaxAthletes())
                .build();
    }
}
