package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.common_data.entity.CompetitionProgram;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionProgramDTO {
    private Integer id;
    private String name;
    private boolean isDel = false;
    private DisciplineTypeDTO disciplineType;

    public static CompetitionProgramDTO from(CompetitionProgram competitionProgram) {
        return builder()
                .id(competitionProgram.getId())
                .name(competitionProgram.getName())
                .isDel(competitionProgram.isDel())
                .disciplineType(DisciplineTypeDTO.from(competitionProgram.getDiscipline()))
                .build();
    }

}
