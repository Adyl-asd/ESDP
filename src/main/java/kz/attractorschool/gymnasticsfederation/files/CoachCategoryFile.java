package kz.attractorschool.gymnasticsfederation.files;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "coach_category_files")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoachCategoryFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String filePath;

    public CoachCategoryFile(String filePath) {
        this.filePath = filePath;
    }
}
