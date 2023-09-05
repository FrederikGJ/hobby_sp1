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
@ToString
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private Integer addressId;

    @Column (name = "address_name", length = 100)
    private String addressName;

    @Column (name = "address_number", nullable = false)
    private int addressNumber;

    @ManyToOne
    @Column (name = "zipcode", nullable = false)
    private Zipcode zipcode;

    @OneToMany (mappedBy = "address")
    private Set<User> users = new HashSet<>();



}
