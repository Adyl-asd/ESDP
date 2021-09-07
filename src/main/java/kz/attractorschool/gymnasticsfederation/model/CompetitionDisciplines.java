package kz.attractorschool.gymnasticsfederation.model;

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

    @ManyToOne
    private Competition competition;

    @OneToOne
    private Discipline discipline;

    @ManyToOne
    private DisciplineType disciplineType;

    @ManyToOne
    private AgeCategories ageCategories;

    @ManyToOne
    private CompetitionProgram competitionProgram;
}
