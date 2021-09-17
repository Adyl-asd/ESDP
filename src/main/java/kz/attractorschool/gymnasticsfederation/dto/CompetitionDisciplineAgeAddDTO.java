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
public class CompetitionDisciplineAgeAddDTO {

    private Integer id;

    @NotNull
    private int teamChampionship;

    @NotNull
    private Integer competitionId;

    private Integer disciplineTypeId;

    private Integer ageCategoryId;

    private Integer maxTeams;

    private Integer maxAthletes;
}
