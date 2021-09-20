package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.model.CompetitionDiscipline;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDisciplineDTO {

    @NotNull
    private Integer id;

    private CompetitionDTO competition;

    private DisciplineTypeDTO disciplineType;

    public static CompetitionDisciplineDTO from(CompetitionDiscipline competitionDiscipline) {
        return builder()
                .id(competitionDiscipline.getId())
                .competition(CompetitionDTO.from(competitionDiscipline.getCompetition()))
                .disciplineType(DisciplineTypeDTO.from(competitionDiscipline.getDiscipline()))
                .build();
    }
}
