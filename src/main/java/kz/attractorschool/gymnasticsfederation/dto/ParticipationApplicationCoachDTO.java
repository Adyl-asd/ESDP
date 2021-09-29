package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.common_data.entity.ParticipationApplicationCoach;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipationApplicationCoachDTO {
    private Integer id;
    private ParticipationApplicationDTO application;
    private CoachDTO coach;

    public static ParticipationApplicationCoachDTO from(ParticipationApplicationCoach applicationCoach){
        return ParticipationApplicationCoachDTO.builder()
                .id(applicationCoach.getId())
                .application(ParticipationApplicationDTO.from(applicationCoach.getApplication()))
                .coach(CoachDTO.from(applicationCoach.getCoach()))
                .build();
    }
}
