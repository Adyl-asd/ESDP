package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
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
public class AgeCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private int minYear;

    @Column
    private int maxYear;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

    @ManyToOne
    private Discipline discipline;

    @ManyToOne
    private Rank rank;
}
