package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "competitions_disciplines")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionDisciplines {
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
    private DisciplineType disciplineType;

    @ManyToOne
    @ToString.Exclude
    private AgeCategory ageCategory;

    @ManyToOne
    @ToString.Exclude
    private CompetitionProgram competitionProgram;
}
