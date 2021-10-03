package kz.attractorschool.gymnasticsfederation.dto;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.common_data.entity.DisciplineType;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineTypeDTO {
    private Integer id;
    private String name;
    private boolean isDel = false;
    private DisciplineDTO discipline;
    private Integer participantsAmountMin;
    private Integer participantsAmountMax;
    private String gender;

    public static DisciplineTypeDTO from(DisciplineType disciplineType) {
        return DisciplineTypeDTO.builder()
                .id(disciplineType.getId())
                .name(disciplineType.getName())
                .participantsAmountMax(disciplineType.getParticipantsAmountMax())
                .participantsAmountMin(disciplineType.getParticipantsAmountMin())
                .gender(disciplineType.getGender().getName())
                .isDel(disciplineType.isDel())
                .discipline(DisciplineDTO.from(disciplineType.getDiscipline()))
                .build();
    }
}
