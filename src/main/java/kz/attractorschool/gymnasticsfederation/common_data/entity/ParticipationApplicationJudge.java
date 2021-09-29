package kz.attractorschool.gymnasticsfederation.common_data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "participation_applications_judges")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipationApplicationJudge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    private ParticipationApplication application;

    @ManyToOne
    private Judge judge;
}
