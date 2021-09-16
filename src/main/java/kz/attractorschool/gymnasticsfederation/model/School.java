package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
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

//    @OneToMany
//    private List<Athlete> athletes;
//
//    @OneToMany
//    private List<Coach> coaches;
}
