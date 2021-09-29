package kz.attractorschool.gymnasticsfederation.common_data.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "athletes_coaches")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AthletesCoaches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Athlete athlete;

    @OneToOne
    private Coach coach;

    @OneToOne
    private School school;

    @Column
    @Builder.Default
    private LocalDate registerDate = LocalDate.now();

    @Column
    private LocalDate finishDate;
}
