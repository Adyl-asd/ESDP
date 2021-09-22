package kz.attractorschool.gymnasticsfederation.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schools")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String director;

//      скорее всего, после создания будут заменены юзером
//    @NotNull
//    private User user;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String password;

    @Column
    @NotNull
    private String address;

    @Column
    @NotNull
    private String phone;

    @ToString.Exclude
    @ManyToOne
    private Federation federation;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

    @JsonManagedReference
    @OneToMany
    @JoinTable(name = "athletes", joinColumns = @JoinColumn(name = "school_id"), inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    @ToString.Exclude
    @Builder.Default
    private List<Athlete> athletes = new ArrayList<>();

    @JsonManagedReference
    @OneToMany
    @JoinTable(name = "coaches", joinColumns = @JoinColumn(name = "school_id"), inverseJoinColumns = @JoinColumn(name = "coach_id"))
    @ToString.Exclude
    @Builder.Default
    private List<Coach> coaches = new ArrayList<>();

    @JsonManagedReference
    @OneToMany
    @JoinTable(name = "judges", joinColumns = @JoinColumn(name = "school_id"), inverseJoinColumns = @JoinColumn(name = "judge_id"))
    @ToString.Exclude
    @Builder.Default
    private List<Judge> judges = new ArrayList<>();
}
