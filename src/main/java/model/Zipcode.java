package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
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

    @OneToMany (mappedBy = "zipcode") //cascading? hvad slettes hvis zipcode slettes?
    private Set<Address> addresses = new HashSet<>();

    public Zipcode(int zipcode, String cityName) {
        this.zipcode = zipcode;
        this.cityName = cityName;
    }
}
