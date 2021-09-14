package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "disciplines")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String name;

    //тип командного первенства, тру - по дисциплине, фолс - по виду спорта
    @Column
    @NotNull
    private boolean isTeamChampByDisciplineType;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

    @OneToMany(mappedBy = "discipline", fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    List<DisciplineType> disciplineTypes = new ArrayList<>();
}
