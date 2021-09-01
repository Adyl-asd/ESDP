package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.files.DopingFile;
import kz.attractorschool.gymnasticsfederation.files.JudgeCategoryFile;
import kz.attractorschool.gymnasticsfederation.files.RegistryFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    private Person person;

    @ManyToOne
    private School school;

    @Column
    @NotNull
    private String registryNumber;

    @OneToOne
    private DopingFile dopingFile;

    @ManyToOne
    private Discipline discipline;

    @ManyToOne
    private JudgeCategory category;

    @OneToOne
    private JudgeCategoryFile categoryFile;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;
}
