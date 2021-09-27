package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.model.JudgeCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JudgeCategoryDTO {
    private Integer id;
    private String name;
    private boolean isDel;

    public static JudgeCategoryDTO from(JudgeCategory judgeCategory){
        return JudgeCategoryDTO.builder()
                .id(judgeCategory.getId())
                .name(judgeCategory.getName())
                .isDel(judgeCategory.isDel())
                .build();
    }
}
