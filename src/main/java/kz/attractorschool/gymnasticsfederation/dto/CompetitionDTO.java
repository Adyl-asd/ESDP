package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.model.Competition;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDTO {
    private Integer id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishDate;
    private LocalDate participationDate;
    private String level;
    private String country;
    private String city;
    private String address;
    private String areaName;
    private String contactName;
    private String contactPhone;
    @ToString.Exclude
    private DisciplineDTO discipline;
    @ToString.Exclude
    private SchoolDTO school;

    public static CompetitionDTO from(Competition competition){
        return kz.attractorschool.gymnasticsfederation.dto.CompetitionDTO.builder()
                .id(competition.getId())
                .name(competition.getName())
                .startDate(competition.getStartDate())
                .finishDate(competition.getFinishDate())
                .participationDate(competition.getParticipationDate())
                .level(competition.getLevel())
                .country(competition.getCountry())
                .city(competition.getCity())
                .address(competition.getAddress())
                .areaName(competition.getAreaName())
                .contactName(competition.getContact())
                .contactPhone(competition.getPhone())
                .discipline(DisciplineDTO.from(competition.getDiscipline()))
                .school(SchoolDTO.from(competition.getSchool()))
                .build();
    }
}
