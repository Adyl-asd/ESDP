package kz.attractorschool.gymnasticsfederation.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
