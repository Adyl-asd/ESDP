package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.model.Discipline;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineDTO {
    private Integer id;
    private String name;
    private boolean isDel;

    public static DisciplineDTO from(Discipline discipline){
        return DisciplineDTO.builder()
                .id(discipline.getId())
                .name(discipline.getName())
                .isDel(discipline.isDel())
                .build();
    }
}
