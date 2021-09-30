package kz.attractorschool.gymnasticsfederation.common_data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.common_data.entity.files.CoachCategoryFile;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "coaches")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ToString.Exclude
    @ManyToOne
    private Person person;

    @ToString.Exclude
    @ManyToOne
    @JsonBackReference
    private School school;

    @Column
    @NotNull
    private String registryNumber;

    @ToString.Exclude
    @OneToOne
    private CoachCategoryFile categoryFile;

    @ToString.Exclude
    @ManyToOne
    private CoachCategory category;

    @ToString.Exclude
    @ManyToOne
    private Discipline discipline;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

    @JsonManagedReference
    @OneToMany
    @ToString.Exclude
    @Builder.Default
    @JoinTable(name = "athletes_coaches", joinColumns = @JoinColumn(name = "coach_id"), inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    private List<Athlete> athletes = new ArrayList<>();
}
