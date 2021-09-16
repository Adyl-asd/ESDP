package kz.attractorschool.gymnasticsfederation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "competitions_discipline_ages")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionDisciplineAge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //тип командного первенства - (0 - нет, 1 - общее, 2 - отдельное)
    @Column
    @NotNull
    private int teamChampionship;

    @ManyToOne
    @ToString.Exclude
    private Competition competition;

    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    private DisciplineType discipline;

    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    private AgeCategory ageCategory;

    @Column
    private Integer maxTeams;

    @Column
    private Integer maxAthletes;
}
