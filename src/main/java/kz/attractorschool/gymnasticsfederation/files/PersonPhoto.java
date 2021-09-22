package kz.attractorschool.gymnasticsfederation.files;

import com.sun.istack.NotNull;
import kz.attractorschool.gymnasticsfederation.model.Person;
import lombok.*;

import javax.persistence.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

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
