package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.common_data.entity.AgeCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgeCategoryDTO {

    @NotNull
    private Integer id;

    private Integer minYear;

    private Integer maxYear;

    @NotNull
    private boolean isDel = false;

    private DisciplineTypeDTO disciplineType;

    @ManyToOne
    private RankDTO rank;

    public static AgeCategoryDTO from(AgeCategory ageCategory) {
        return builder()
                .id(ageCategory.getId())
                .minYear(ageCategory.getMinYear())
                .maxYear(ageCategory.getMaxYear())
                .isDel(ageCategory.isDel())
                .disciplineType(DisciplineTypeDTO.from(ageCategory.getDiscipline()))
                .rank(RankDTO.from(ageCategory.getRank()))
                .build();
    }
}
