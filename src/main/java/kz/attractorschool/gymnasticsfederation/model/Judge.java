package kz.attractorschool.gymnasticsfederation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.files.DopingFile;
import kz.attractorschool.gymnasticsfederation.files.JudgeCategoryFile;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "judges")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Judge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ToString.Exclude
    @ManyToOne
    private Person person;

    @ToString.Exclude
    @ManyToOne
    @JsonBackReference
    private School school;

    @Column
    @NotNull
    private String registryNumber;

    @ToString.Exclude
    @OneToOne
    private DopingFile dopingFile;

    @ToString.Exclude
    @ManyToOne
    private Discipline discipline;

    @ToString.Exclude
    @ManyToOne
    private JudgeCategory category;

    @ToString.Exclude
    @OneToOne
    private JudgeCategoryFile categoryFile;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;
}
