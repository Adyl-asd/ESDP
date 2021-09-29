package kz.attractorschool.gymnasticsfederation.common_data.entity.files;

import com.sun.istack.NotNull;
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
