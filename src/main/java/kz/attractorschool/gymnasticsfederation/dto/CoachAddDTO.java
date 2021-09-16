package kz.attractorschool.gymnasticsfederation.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoachAddDTO {

    private Integer id;

    @NotNull
    @Min(1)
    private Integer personId;

    @NotNull
    @Min(1)
    private Integer schoolId;

    @NotNull
    @Min(1)
    private Integer disciplineId;

    @NotNull
    @Min(1)
    private Integer categoryId;

}
