package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.model.CoachCategory;
import kz.attractorschool.gymnasticsfederation.model.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoachCategoryDTO {
    private Integer id;

    @org.hibernate.validator.constraints.NotBlank
    @Size(min = 1, message = "Вы ввели пустое значение")
    private String name;

    private boolean isDel;

    public static CoachCategoryDTO from(CoachCategory coachCategory){
        return CoachCategoryDTO.builder()
                .id(coachCategory.getId())
                .name(coachCategory.getName())
                .isDel(coachCategory.isDel())
                .build();
    }
}
