package kz.attractorschool.gymnasticsfederation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionAddDTO {

    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate endDate;

    @NotNull
    private String country;

    @NotNull
    private String city;

    @NotNull
    private String address;

    @NotNull
    private String areaName;

    @NotNull
    private String contactName;

    @NotNull
    private String contactPhone;

    @NotNull
    @Min(1)
    private Integer disciplineId;

    @NotNull
    @Min(1)
    private Integer schoolId;
}
