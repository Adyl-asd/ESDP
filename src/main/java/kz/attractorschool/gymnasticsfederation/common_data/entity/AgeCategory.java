package kz.attractorschool.gymnasticsfederation.common_data.entity;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

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

    @JsonBackReference
    @ManyToOne
    @ToString.Exclude
    private DisciplineType discipline;

    @ManyToOne
    @ToString.Exclude
    private Rank rank;
}
