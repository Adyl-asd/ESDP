package kz.attractorschool.gymnasticsfederation.common_data.entity.files;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "photos")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonPhoto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String filePath;

    public PersonPhoto(String filePath) {
        this.filePath = filePath;
    }
}
