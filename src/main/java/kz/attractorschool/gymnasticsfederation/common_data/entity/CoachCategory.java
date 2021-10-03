package kz.attractorschool.gymnasticsfederation.common_data.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "coach_categories")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoachCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    @Builder.Default
    private boolean isDel = false;
}
