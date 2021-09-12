package kz.attractorschool.gymnasticsfederation.model;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "age_categories")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer minYear;

    @Column
    private Integer maxYear;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

    @ManyToOne
    private DisciplineType disciplineType;

    @ManyToOne
    private Rank rank;
}
