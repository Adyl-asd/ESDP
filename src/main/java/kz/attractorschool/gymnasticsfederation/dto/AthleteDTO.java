package kz.attractorschool.gymnasticsfederation.dto;

import kz.attractorschool.gymnasticsfederation.common_data.entity.Athlete;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AthleteDTO {
    private Integer id;
    @ToString.Exclude
    private PersonDTO person;
    @ToString.Exclude
    private SchoolDTO school;
    private String registryNumber;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registryDate;
    @ToString.Exclude
    private DisciplineDTO discipline;
    @ToString.Exclude
    private RankDTO rank;
    private boolean isDel;
    private boolean isNationalTeam;
    private boolean isCityTeam;
    private String medicalFile;
    private String dopingFile;
    private String registryFile;
    private String rankFile;

    public static AthleteDTO from(Athlete athlete){
        return AthleteDTO.builder()
                .id(athlete.getId())
                .person(PersonDTO.from(athlete.getPerson()))
                .school(SchoolDTO.from(athlete.getSchool()))
                .registryNumber(athlete.getRegistryNumber())
                .status(athlete.getStatus())
                .registryDate(athlete.getRegistryDate())
                .discipline(DisciplineDTO.from(athlete.getDiscipline()))
                .rank(RankDTO.from(athlete.getRank()))
                .isDel(athlete.isDel())
                .isCityTeam(athlete.isCityTeam())
                .isNationalTeam(athlete.isNationalTeam())
                .medicalFile(athlete.getMedicalFile().getFilePath())
                .dopingFile(athlete.getDopingFile().getFilePath())
                .registryFile(athlete.getRegistryFile().getFilePath())
                .rankFile(athlete.getRankFile().getFilePath())
                .build();
    }
}
