package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.common_data.entity.Discipline;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineDTO {
    private Integer id;

    @NotNull
    @Size(min = 1, message = "Вы ввели пустое значение")
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
