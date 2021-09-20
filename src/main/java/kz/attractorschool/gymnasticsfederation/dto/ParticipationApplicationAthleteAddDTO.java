package kz.attractorschool.gymnasticsfederation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipationApplicationAthleteAddDTO {
    private Integer applicationId;
    private Integer athleteId;
    private Integer disciplineAgeId;
}
