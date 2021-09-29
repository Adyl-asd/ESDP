package kz.attractorschool.gymnasticsfederation.common_data.entity.files;

import com.sun.istack.NotNull;
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

    public DopingFile(String filePath) {
        this.filePath = filePath;
    }
}
