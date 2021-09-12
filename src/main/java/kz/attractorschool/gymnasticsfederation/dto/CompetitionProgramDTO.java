package kz.attractorschool.gymnasticsfederation.dto;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.model.CompetitionProgram;
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

    @NotNull
    private String name;

    @NotNull
    private boolean isDel = false;

    private String type;

    private DisciplineTypeDTO disciplineType;

    public CompetitionProgramDTO from(CompetitionProgram competitionProgram) {
        return builder()
                .id(competitionProgram.getId())
                .name(competitionProgram.getName())
                .isDel(competitionProgram.isDel())
                .type(competitionProgram.getType())
                .disciplineType(DisciplineTypeDTO.from(competitionProgram.getDisciplineType()))
                .build();
    }

}
