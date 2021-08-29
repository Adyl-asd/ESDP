package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "men")
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
    private String patronymic;

    @Column
    @NotNull
    private String photo;

    @Column
    @NotNull
    private LocalDate birthday;

    @Column
    @NotNull
    private String iin;

    @Column
    @NotNull
    private String city;

    @Column
    @NotNull
    private String address;

    @Column
    @NotNull
    private String phoneNumber;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String education;

    @Column
    @NotNull
    private String comment;
}
