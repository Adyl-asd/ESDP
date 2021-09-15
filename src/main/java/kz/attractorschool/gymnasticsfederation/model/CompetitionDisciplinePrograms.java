package kz.attractorschool.gymnasticsfederation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "competitions_discipline_programs")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionDisciplinePrograms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @ToString.Exclude
    private Competition competition;

    @ManyToOne
    @ToString.Exclude
    private DisciplineType discipline;

    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    private CompetitionProgram competitionProgram;
}
