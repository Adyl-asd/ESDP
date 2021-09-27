package kz.attractorschool.gymnasticsfederation.dto;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.enumm.Status;
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
public class AthleteRegisterDTO {
    private Integer id;

    @NotNull
    @Min(1)
    private Integer schoolId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Builder.Default
    private LocalDate registryDate = LocalDate.now();

    @NotNull
    @Min(1)
    private Integer rankId;

    @Builder.Default
    private String status = Status.UNDER_CONSIDERATION.getName();
}
