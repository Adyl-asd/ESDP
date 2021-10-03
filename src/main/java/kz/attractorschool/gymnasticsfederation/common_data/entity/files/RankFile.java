package kz.attractorschool.gymnasticsfederation.common_data.entity.files;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Table(name = "rank_files")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RankFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String filePath;

    public RankFile(String filePath) {
        this.filePath = filePath;
    }
}
