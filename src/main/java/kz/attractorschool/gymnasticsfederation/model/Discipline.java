package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "disciplines")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Discipline {
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

    @OneToMany(mappedBy = "discipline", fetch = FetchType.LAZY)
    @Builder.Default
    List<DisciplineType> disciplineTypes = new ArrayList<>();

    @OneToMany(mappedBy = "discipline", fetch = FetchType.LAZY)
    @Builder.Default
    List<CompetitionProgram> competitionPrograms = new ArrayList<>();

    @OneToMany(mappedBy = "discipline", fetch = FetchType.LAZY)
    @Builder.Default
    List<AgeCategories> ageCategories = new ArrayList<>();
}
