package kz.attractorschool.gymnasticsfederation.dto;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.model.Competition;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplication;
import kz.attractorschool.gymnasticsfederation.model.School;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipationApplicationDTO {
    private Integer id;
    private LocalDate creationDate;
    private boolean isDel;
    private CompetitionDTO competition;
    private SchoolDTO school;

    public static ParticipationApplicationDTO from(ParticipationApplication application) {
        return ParticipationApplicationDTO.builder()
                .id(application.getId())
                .creationDate(application.getCreationDate())
                .isDel(application.isDel())
                .school(SchoolDTO.from(application.getSchool()))
                .competition(CompetitionDTO.from(application.getCompetition()))
                .build();
    }
}
