package kz.attractorschool.gymnasticsfederation.common_data.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "federations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Federation {
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

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

//    @ToString.Exclude
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "federation")
//    List<School> schools;
}