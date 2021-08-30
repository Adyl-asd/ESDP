package kz.attractorschool.gymnasticsfederation.files;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.model.Athlete;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "rank_files")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RankFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String filePath;

    @OneToOne
    @ToString.Exclude
    private Athlete athlete;

    public RankFile(String filePath) {
        this.filePath = filePath;
    }

}
