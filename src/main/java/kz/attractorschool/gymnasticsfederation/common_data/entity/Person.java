package kz.attractorschool.gymnasticsfederation.common_data.entity;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.common_data.entity.files.PersonPhoto;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "persons")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String surname;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String middleName;

    @OneToOne
    private PersonPhoto photo;

    @Column
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column
    @NotNull
    private String iin;

    @Column
    @NotNull
    private String gender;

    @Column
    @NotNull
    private String city;

    @Column
    @NotNull
    private String address;

    @Column
    @NotNull
    private String phone;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String education;

    @Column
    @NotNull
    private String comment;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    @Builder.Default
    List<Athlete> athletes = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    @Builder.Default
    List<Judge> judges = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    @Builder.Default
    List<Coach> coaches = new ArrayList<>();
}
