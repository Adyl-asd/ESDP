package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Competition competition;

    @ManyToOne
    private DisciplineType disciplineType;

    @ManyToOne
    private AgeCategory ageCategory;

    @ManyToOne
    private CompetitionProgram competitionProgram;
}
