package kz.attractorschool.gymnasticsfederation.files;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.model.Athlete;
import kz.attractorschool.gymnasticsfederation.model.Coach;
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
    private String file_path;

    @OneToOne
    @ToString.Exclude
    private Coach coach;
}
