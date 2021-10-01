package kz.attractorschool.gymnasticsfederation.common_data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "competition_programs")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

    @JsonBackReference
    @ManyToOne
    @ToString.Exclude
    private DisciplineType discipline;
}
