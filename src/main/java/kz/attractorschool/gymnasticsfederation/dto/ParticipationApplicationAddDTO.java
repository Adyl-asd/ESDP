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
public class ParticipationApplicationAddDTO {
    @NotNull
    private Integer competitionId;

    @NotNull
    private Integer schoolId;
}
