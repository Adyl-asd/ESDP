package kz.attractorschool.gymnasticsfederation.files;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.model.Athlete;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "doping_files")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DopingFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String filePath;

    @OneToOne
    @ToString.Exclude
    private Athlete athlete;

    public DopingFile(String filePath) {
        this.filePath = filePath;
    }
}
