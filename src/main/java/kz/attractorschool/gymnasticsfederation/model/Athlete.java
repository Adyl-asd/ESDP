package kz.attractorschool.gymnasticsfederation.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import kz.attractorschool.gymnasticsfederation.files.DopingFile;
import kz.attractorschool.gymnasticsfederation.files.MedicalFile;
import kz.attractorschool.gymnasticsfederation.files.RankFile;
import kz.attractorschool.gymnasticsfederation.files.RegistryFile;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "men")
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
    private Integer registryNumber;

    @OneToOne
    private RegistryFile registryFile;

    @OneToOne
    private MedicalFile medicalFile;

    @OneToOne
    private DopingFile dopingFile;

    @Column
    @NotNull
    @Builder.Default
    private String status = "active";

    @Column
    @NotNull
    private LocalDate registryDate;

    @ManyToOne
    private Discipline discipline;

    @ManyToOne
    private Rank rank;

    @OneToOne
    private RankFile rankFile;

    @ManyToMany
    private List<Coach> coaches;

    //гос награды?


}
