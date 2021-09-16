package kz.attractorschool.gymnasticsfederation.files;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "competition_position_files")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionPositionFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String filePath;

    public CompetitionPositionFile(String filePath) {
        this.filePath = filePath;
    }
}
