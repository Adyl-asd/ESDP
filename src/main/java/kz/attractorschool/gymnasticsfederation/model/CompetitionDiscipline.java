package kz.attractorschool.gymnasticsfederation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "competitions_discipline")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionDiscipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @ToString.Exclude
    private Competition competition;

    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    private DisciplineType discipline;
}
