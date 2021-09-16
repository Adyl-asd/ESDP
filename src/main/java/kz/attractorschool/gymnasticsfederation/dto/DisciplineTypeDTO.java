package kz.attractorschool.gymnasticsfederation.dto;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.model.DisciplineType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineTypeDTO {

    private Integer id;

    @NotNull
    private String name;

    private boolean isDel = false;

    private DisciplineDTO discipline;

    public static DisciplineTypeDTO from(DisciplineType disciplineType) {
        return DisciplineTypeDTO.builder()
                .id(disciplineType.getId())
                .name(disciplineType.getName())
                .isDel(disciplineType.isDel())
                .discipline(DisciplineDTO.from(disciplineType.getDiscipline()))
                .build();
    }
}
