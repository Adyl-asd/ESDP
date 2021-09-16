package kz.attractorschool.gymnasticsfederation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "discipline")
    @ToString.Exclude
    private List<CompetitionProgram> programs;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "discipline")
    @ToString.Exclude
    private List<AgeCategory> ageCategories;
}
