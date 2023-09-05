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
public class Zipcode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zip", nullable = false)
    private int zipcode;

    @Column (name = "city_name", length = 100)
    private String cityName;

    @Column (name = "region_name", length = 100)
    private String regionName;

    @Column (name = "municipality_name", length = 100)
    private String municipalityName;

    public Zipcode(int zipcode, String cityName, String regionName, String municipalityName) {
        this.zipcode = zipcode;
        this.cityName = cityName;
        this.regionName = regionName;
        this.municipalityName = municipalityName;
    }
}
