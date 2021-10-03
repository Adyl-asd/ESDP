package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.common_data.entity.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankDTO {
    private Integer id;

    @NotNull
    @Size(min = 1, message = "Вы ввели пустое значение")
    private String name;

    private boolean isDel;

    public static RankDTO from(Rank rank){
        return RankDTO.builder()
                .id(rank.getId())
                .name(rank.getName())
                .isDel(rank.isDel())
                .build();
    }
}
