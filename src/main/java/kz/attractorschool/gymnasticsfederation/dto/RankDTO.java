package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.model.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankDTO {
    private Integer id;
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
