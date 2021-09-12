package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "competition_programs")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

    @ManyToOne
    private AgeCategory ageCategory;

    @ManyToOne
    private DisciplineType disciplineType;

    @Column
    private String type;
}
