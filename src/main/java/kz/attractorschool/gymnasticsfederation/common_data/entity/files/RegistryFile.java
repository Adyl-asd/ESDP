package kz.attractorschool.gymnasticsfederation.common_data.entity.files;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "registry_files")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistryFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String filePath;

    public RegistryFile(String filePath) {
        this.filePath = filePath;
    }
}
