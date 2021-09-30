package kz.attractorschool.gymnasticsfederation.common_data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany
    @JoinTable(name = "discipline_types", joinColumns = @JoinColumn(name = "discipline_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    @ToString.Exclude
    @Builder.Default
    @JsonManagedReference
    List<DisciplineType> disciplineTypes = new ArrayList<>();
}
