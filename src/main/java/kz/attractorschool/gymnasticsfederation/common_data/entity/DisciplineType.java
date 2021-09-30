package kz.attractorschool.gymnasticsfederation.common_data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany
    @JoinTable(name = "competition_programs", joinColumns = @JoinColumn(name = "discipline_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    @ToString.Exclude
    @Builder.Default
    @JsonManagedReference
    private List<CompetitionProgram> programs = new ArrayList<>( );

    @OneToMany
    @JoinTable(name = "age_categories", joinColumns = @JoinColumn(name = "discipline_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    @ToString.Exclude
    @Builder.Default
    @JsonManagedReference
    List<AgeCategory> ageCategories = new ArrayList<>();
}
