package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.model.Coach;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoachDTO {

    private Integer id;

    @ToString.Exclude
    private PersonDTO person;

    @ToString.Exclude
    private SchoolDTO school;

    private String registryNumber;

    @ToString.Exclude
    private CoachCategoryDTO category;

    @ToString.Exclude
    private DisciplineDTO discipline;

    private boolean isDel;

    @ToString.Exclude
    private List<AthleteDTO> athletes;

    public static CoachDTO from(Coach coach) {
        return CoachDTO.builder()
                .id(coach.getId())
                .person(PersonDTO.from(coach.getPerson()))
                .school(SchoolDTO.from(coach.getSchool()))
                .registryNumber(coach.getRegistryNumber())
                .category(CoachCategoryDTO.from(coach.getCategory()))
                .discipline(DisciplineDTO.from(coach.getDiscipline()))
                .isDel(coach.isDel())
                .build();
    }

}
