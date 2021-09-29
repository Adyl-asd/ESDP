package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.common_data.entity.Judge;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JudgeDTO {
    private Integer id;
    @ToString.Exclude
    private PersonDTO person;
    @ToString.Exclude
    private SchoolDTO school;
    private String registryNumber;
    @ToString.Exclude
    private DisciplineDTO discipline;
    @ToString.Exclude
    private JudgeCategoryDTO category;
    private boolean isDel = false;
    private String categoryFile;

    public static JudgeDTO from(Judge judge){
        return JudgeDTO.builder()
                .id(judge.getId())
                .person(PersonDTO.from(judge.getPerson()))
                .school(SchoolDTO.from(judge.getSchool()))
                .registryNumber(judge.getRegistryNumber())
                .discipline(DisciplineDTO.from(judge.getDiscipline()))
                .category(JudgeCategoryDTO.from(judge.getCategory()))
                .categoryFile(judge.getCategoryFile().getFilePath())
                .build();
    }
}
