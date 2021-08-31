package kz.attractorschool.gymnasticsfederation.files;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.model.Athlete;
import kz.attractorschool.gymnasticsfederation.model.Judge;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "judge_category_files")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JudgeCategoryFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String filePath;

    public JudgeCategoryFile(String filePath) {
        this.filePath = filePath;
    }
}
