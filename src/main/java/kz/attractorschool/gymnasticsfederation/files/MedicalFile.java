package kz.attractorschool.gymnasticsfederation.files;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.model.Athlete;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "medical_files")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String file_path;

    @OneToOne
    @ToString.Exclude
    private Athlete athlete;
}
