package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.model.Athlete;
import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplineAge;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplication;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplicationAthlete;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
