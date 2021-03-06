package kz.attractorschool.gymnasticsfederation.common_data.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.common_data.enumiration.Status;
import lombok.*;

import kz.attractorschool.gymnasticsfederation.common_data.entity.files.DopingFile;
import kz.attractorschool.gymnasticsfederation.common_data.entity.files.MedicalFile;
import kz.attractorschool.gymnasticsfederation.common_data.entity.files.RankFile;
import kz.attractorschool.gymnasticsfederation.common_data.entity.files.RegistryFile;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
    @JsonBackReference
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
    private String status = Status.UNDER_CONSIDERATION.getName();

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

    @JsonManagedReference
    @OneToMany
    @ToString.Exclude
    @Builder.Default
    @JoinTable(name = "athletes_coaches", joinColumns = @JoinColumn(name = "athlete_id"), inverseJoinColumns = @JoinColumn(name = "coach_id"))
    private List<Coach> coaches = new ArrayList<>();

    //?????? ???????????????
}
