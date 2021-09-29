package kz.attractorschool.gymnasticsfederation.common_data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

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
    @ToString.Exclude
    @JsonBackReference
    private ParticipationApplication application;

    @ManyToOne
    @ToString.Exclude
    private Athlete athlete;

    @ManyToOne
    @ToString.Exclude
    private CompetitionDisciplineAge disciplineAge;

    @ManyToOne
    @ToString.Exclude
    private DisciplineType disciplineType;
}
