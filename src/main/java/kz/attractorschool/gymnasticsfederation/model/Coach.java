package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.files.DopingFile;
import kz.attractorschool.gymnasticsfederation.files.RegistryFile;
import lombok.*;

import javax.persistence.*;
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
    private School school;

    @Column
    @NotNull
    private String registryNumber;

    @ToString.Exclude
    @OneToOne
    private DopingFile dopingFile;

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

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "athletes_coaches", joinColumns = @JoinColumn(name = "coach_id"), inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    private List<Athlete> athletes;
}
