package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.enumm.CompetitionStatus;
import kz.attractorschool.gymnasticsfederation.files.CompetitionPositionFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

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
    private CompetitionPositionFile competitionPositionFile;

    @ManyToOne
    private School school;
}
