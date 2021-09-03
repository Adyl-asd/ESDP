package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.model.JudgeCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JudgeCategoryDTO {
    private Integer id;

    @NotNull
    @Min(1)
    private Integer number;

    private boolean isDel;

    public static JudgeCategoryDTO from(JudgeCategory judgeCategory){
        return JudgeCategoryDTO.builder()
                .id(judgeCategory.getId())
                .number(judgeCategory.getNumber())
                .isDel(judgeCategory.isDel())
                .build();
    }
}
