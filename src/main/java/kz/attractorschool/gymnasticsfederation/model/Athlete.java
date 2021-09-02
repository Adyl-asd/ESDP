package kz.attractorschool.gymnasticsfederation.model;


import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.enumm.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import kz.attractorschool.gymnasticsfederation.files.DopingFile;
import kz.attractorschool.gymnasticsfederation.files.MedicalFile;
import kz.attractorschool.gymnasticsfederation.files.RankFile;
import kz.attractorschool.gymnasticsfederation.files.RegistryFile;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

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

    @ManyToOne
    private Person person;

    @ManyToOne
    private School school;

    @Column
    @NotNull
    private String registryNumber;

    @OneToOne
    private RegistryFile registryFile;

    @OneToOne
    private MedicalFile medicalFile;

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

    @ManyToOne
    private Discipline discipline;

    @ManyToOne
    private Rank rank;

    @OneToOne
    private RankFile rankFile;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

//    @ManyToMany
//    @JoinTable(name = "athletes_coaches", joinColumns = @JoinColumn(name = "athlete_id"), inverseJoinColumns = @JoinColumn(name = "coach_id"))
//    private List<Coach> coaches;

    //гос награды?
}
