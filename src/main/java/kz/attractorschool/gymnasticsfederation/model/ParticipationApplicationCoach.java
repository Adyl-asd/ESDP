package kz.attractorschool.gymnasticsfederation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "participation_applications_coaches")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipationApplicationCoach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private ParticipationApplication application;

    @ManyToOne
    private Coach coach;
}
