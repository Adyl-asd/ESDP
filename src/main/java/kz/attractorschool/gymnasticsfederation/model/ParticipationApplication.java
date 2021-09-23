package kz.attractorschool.gymnasticsfederation.model;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.enumm.ParticipationApplicationStatus;
import kz.attractorschool.gymnasticsfederation.repository.ParticipationApplicationRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "participation_applications")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipationApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Builder.Default
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate = LocalDate.now();

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;

    @Column
    @NotNull
    @Builder.Default
    private String status = ParticipationApplicationStatus.СОЗДАНА.name();

    @ManyToOne
    private Competition competition;

    @OneToOne
    private School school;
}
