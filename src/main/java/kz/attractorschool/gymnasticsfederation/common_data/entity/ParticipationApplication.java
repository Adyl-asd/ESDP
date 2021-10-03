package kz.attractorschool.gymnasticsfederation.common_data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.common_data.enumiration.ParticipationApplicationStatus;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "participation_applications")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipationApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Builder.Default
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate = LocalDate.now();

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

    @Column
    @NotNull
    @Builder.Default
    private String status = ParticipationApplicationStatus.CREATED.name();

    @ManyToOne
    private Competition competition;

    @OneToOne
    private School school;

    @JsonManagedReference
    @OneToMany
    @JoinTable(name = "participation_applications_athletes", joinColumns = @JoinColumn(name = "application_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    @ToString.Exclude
    @Builder.Default
    private List<ParticipationApplicationAthlete> applicationAthletes = new ArrayList<>();

    @JsonManagedReference
    @OneToMany
    @JoinTable(name = "participation_applications_coaches", joinColumns = @JoinColumn(name = "application_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    @ToString.Exclude
    @Builder.Default
    private List<ParticipationApplicationCoach> applicationCoaches = new ArrayList<>();

    @JsonManagedReference
    @OneToMany
    @JoinTable(name = "participation_applications_judges", joinColumns = @JoinColumn(name = "application_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    @ToString.Exclude
    @Builder.Default
    private List<ParticipationApplicationJudge> applicationJudges = new ArrayList<>();

}
