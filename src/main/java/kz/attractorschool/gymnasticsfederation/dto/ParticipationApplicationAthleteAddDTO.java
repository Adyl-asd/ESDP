package kz.attractorschool.gymnasticsfederation.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipationApplicationAthleteAddDTO {
//    @NotNull
//    private Integer applicationId;

    @NotNull
    private Integer athleteId;

    @NotNull
    private Integer disciplineAgeId;
}
