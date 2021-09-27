package kz.attractorschool.gymnasticsfederation.dto;

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
public class JudgeCategoryAddDTO {
    @NotNull
    @Size(min = 1, message = "Вы ввели пустое значение")
    private String name;
}
