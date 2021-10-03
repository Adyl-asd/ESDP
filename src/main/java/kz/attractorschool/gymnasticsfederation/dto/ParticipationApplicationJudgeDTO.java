package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.common_data.entity.ParticipationApplicationJudge;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipationApplicationJudgeDTO {
    private Integer id;
    private ParticipationApplicationDTO application;
    private JudgeDTO judge;

    public static ParticipationApplicationJudgeDTO from(ParticipationApplicationJudge applicationJudge){
        return ParticipationApplicationJudgeDTO.builder()
                .id(applicationJudge.getId())
                .application(ParticipationApplicationDTO.from(applicationJudge.getApplication()))
                .judge(JudgeDTO.from(applicationJudge.getJudge()))
                .build();
    }
}
