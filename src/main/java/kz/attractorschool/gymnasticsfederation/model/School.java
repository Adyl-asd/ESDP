package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    private Federation federation;

    @OneToMany
    private List<Athlete> athletes;

    @OneToMany
    private List<Coach> coaches;
}
