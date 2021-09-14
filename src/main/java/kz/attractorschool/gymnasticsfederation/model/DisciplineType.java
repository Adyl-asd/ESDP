package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "discipline_types")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DisciplineType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    private Integer participantsAmountMin;

    @Column
    private Integer participantsAmountMax;

    @ManyToOne
    private Gender gender;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

    @ManyToOne
    @ToString.Exclude
    private Discipline discipline;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "discipline")
    @ToString.Exclude
//    @OneToMany
//    @JoinTable(name = "competition_programs", joinColumns = @JoinColumn(name = "discipline_type_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private List<CompetitionProgram> programs;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "discipline")
    @ToString.Exclude
//    @OneToMany
//    @JoinTable(name = "age_categories", joinColumns = @JoinColumn(name = "discipline_type_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private List<AgeCategory> ageCategories;
}
