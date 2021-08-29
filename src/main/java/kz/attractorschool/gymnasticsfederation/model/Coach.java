package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.files.DopingFile;
import kz.attractorschool.gymnasticsfederation.files.MedicalFile;
import kz.attractorschool.gymnasticsfederation.files.RegistryFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    private Person person;

    @ManyToOne
    private School school;

    @Column
    @NotNull
    private Integer registryNumber;

    @OneToOne
    private RegistryFile registryFile;

    @OneToOne
    private DopingFile dopingFile;

    @ManyToOne
    private CoachCategory category;

    @ManyToMany
    @JoinTable(name = "athletes_coaches", joinColumns = @JoinColumn(name = "coach_id"), inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    private List<Athlete> athletes;
}
