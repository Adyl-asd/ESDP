package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.common_data.entity.ParticipationApplicationAthlete;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipationApplicationAthleteDTO {
    private Integer id;
    private ParticipationApplicationDTO application;
    private AthleteDTO athlete;
    private CompetitionDisciplineAgeDTO disciplineAge;
    private DisciplineTypeDTO disciplineType;

    public static ParticipationApplicationAthleteDTO from(ParticipationApplicationAthlete applicationAthlete){
        return ParticipationApplicationAthleteDTO.builder()
                .id(applicationAthlete.getId())
                .application(ParticipationApplicationDTO.from(applicationAthlete.getApplication()))
                .athlete(AthleteDTO.from(applicationAthlete.getAthlete()))
                .disciplineAge(CompetitionDisciplineAgeDTO.from(applicationAthlete.getDisciplineAge()))
                .disciplineType(DisciplineTypeDTO.from(applicationAthlete.getDisciplineType()))
                .build();
    }
}
