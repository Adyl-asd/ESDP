package kz.attractorschool.gymnasticsfederation.common_data.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Athlete athlete;

    @OneToOne
    @JsonBackReference
    private Coach coach;

    @OneToOne
    @JsonBackReference
    private School school;

    @Column
    @Builder.Default
    private LocalDate registerDate = LocalDate.now();

    @Column
    private LocalDate finishDate;
}
