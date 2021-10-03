package kz.attractorschool.gymnasticsfederation.common_data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "all_arounds")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllAround {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Competition competition;

    @OneToOne
    private DisciplineType discipline;

    @JsonManagedReference
    @OneToMany
    @JoinTable(name = "competitions_discipline_programs", joinColumns = @JoinColumn(name = "competition_id"), inverseJoinColumns = @JoinColumn(name = "competition_program_id"))
    @ToString.Exclude
    @Builder.Default
    private List<CompetitionProgram> programs = new ArrayList<>();

    @JsonManagedReference
    @OneToMany
    @JoinTable(name = "competitions_discipline_ages", joinColumns = @JoinColumn(name = "competition_id"), inverseJoinColumns = @JoinColumn(name = "age_category_id"))
    @ToString.Exclude
    @Builder.Default
    private List<AgeCategory> ageCategories = new ArrayList<>();
}
