package kz.attractorschool.gymnasticsfederation.model;


import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.enumm.Status;
import lombok.*;

import kz.attractorschool.gymnasticsfederation.files.DopingFile;
import kz.attractorschool.gymnasticsfederation.files.MedicalFile;
import kz.attractorschool.gymnasticsfederation.files.RankFile;
import kz.attractorschool.gymnasticsfederation.files.RegistryFile;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "athletes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Athlete {
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
    private RegistryFile registryFile;

    @ToString.Exclude
    @OneToOne
    private MedicalFile medicalFile;

    @ToString.Exclude
    @OneToOne
    private DopingFile dopingFile;

    @Column
    @NotNull
    @Builder.Default
    private String status = Status.НА_РАССМОТРЕНИИ.toString();

    @Column
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registryDate;

    @Column
    @NotNull
    private boolean isCityTeam;

    @Column
    @NotNull
    private boolean isNationalTeam;

    @ToString.Exclude
    @ManyToOne
    private Discipline discipline;

    @ToString.Exclude
    @ManyToOne
    private Rank rank;

    @ToString.Exclude
    @OneToOne
    private RankFile rankFile;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

    @ManyToMany
    @JoinTable(name = "athletes_coaches", joinColumns = @JoinColumn(name = "athlete_id"), inverseJoinColumns = @JoinColumn(name = "coach_id"))
    private List<Coach> coaches;

    //гос награды?
}
