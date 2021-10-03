package kz.attractorschool.gymnasticsfederation.common_data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JsonManagedReference
    @OneToMany
    @JoinTable(name = "schools", joinColumns = @JoinColumn(name = "federation_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    @ToString.Exclude
    @Builder.Default
    List<School> schools = new ArrayList<>();
}
