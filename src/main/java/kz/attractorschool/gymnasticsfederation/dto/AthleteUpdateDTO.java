package kz.attractorschool.gymnasticsfederation.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AthleteUpdateDTO {
    @NotNull
    @Min(1)
    private Integer schoolId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate registryDate;

    @NotNull
    @Min(1)
    private Integer disciplineId;

    @NotNull
    @Min(1)
    private Integer rankId;
}
