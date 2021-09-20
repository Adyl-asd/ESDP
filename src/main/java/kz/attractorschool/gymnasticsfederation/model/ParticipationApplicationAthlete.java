package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "participation_applications_athletes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipationApplicationAthlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private ParticipationApplication application;

    @ManyToOne
    private Athlete athlete;

    @ManyToOne
    private CompetitionDisciplineAge disciplineAge;
}
