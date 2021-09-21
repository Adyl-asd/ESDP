package kz.attractorschool.gymnasticsfederation.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.enumm.CompetitionStatus;
import kz.attractorschool.gymnasticsfederation.files.CompetitionPositionFile;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "competitions")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    @Builder.Default
    private LocalDate creationDate = LocalDate.now();

    @Column
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishDate;

    @Column
    @NotNull
    private LocalDate participationDate;

    @Column
    @NotNull
    private String level;

    @Column
    @NotNull
    private String country;

    @Column
    @NotNull
    private String city;

    @Column
    @NotNull
    private String address;

    @Column
    @NotNull
    private String areaName;

    @Column
    @NotNull
    private String contact;

    @Column
    @NotNull
    private String phone;

    @ManyToOne
    @ToString.Exclude
    private Discipline discipline;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

    @Column
    @NotNull
    @Builder.Default
    private String status = CompetitionStatus.СОЗДАНО.name();

    @OneToOne
    @ToString.Exclude
    private CompetitionPositionFile competitionPositionFile;

    @ManyToOne
    @ToString.Exclude
    private School school;

    @JsonManagedReference
    @OneToMany
    @JoinTable(name = "competitions_discipline_ages", joinColumns = @JoinColumn(name = "competition_id"), inverseJoinColumns = @JoinColumn(name = "discipline_id"))
    @ToString.Exclude
    @Builder.Default
    List<DisciplineType> disciplineTypes = new ArrayList<>();

    @JsonManagedReference
    @OneToMany
    @JoinTable(name = "competitions_discipline_ages", joinColumns = @JoinColumn(name = "competition_id"), inverseJoinColumns = @JoinColumn(name = "age_category_id"))
    @ToString.Exclude
    @Builder.Default
    List<AgeCategory> ageCategories = new ArrayList<>();

    @JsonManagedReference
    @OneToMany
    @JoinTable(name = "competitions_discipline_programs", joinColumns = @JoinColumn(name = "competition_id"), inverseJoinColumns = @JoinColumn(name = "competition_program_id"))
    @ToString.Exclude
    @Builder.Default
    List<CompetitionProgram> competitionPrograms = new ArrayList<>();
}
