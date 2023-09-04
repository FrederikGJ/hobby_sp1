package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Zip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "zip_id", nullable = false)
    private int zipId;

    @Column(name = "zipcode", nullable = false)

    private int zipcode;

    @Column (name = "city_name", length = 100)
    private String cityName;
}
