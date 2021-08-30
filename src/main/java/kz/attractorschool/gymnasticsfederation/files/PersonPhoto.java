package kz.attractorschool.gymnasticsfederation.files;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.model.Person;
import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "photos")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String filePath;

    @OneToOne
    @ToString.Exclude
    private Person person;

    public PersonPhoto(String filePath) {
        this.filePath = filePath;
    }
}
