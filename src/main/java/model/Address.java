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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private int addressId;

    @Column (name = "address_name", length = 100)
    private String addressName;

    @Column (name = "address_number", nullable = false)
    private int addressNumber;

    // Multiple Addresses can have the same zipcode and city infomation
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="zip")
    private Zipcode zipcode;

    //multible users at live at the same address
    @OneToMany
    private Set<Users> users = new HashSet<>();

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Users user) {
        users.add(user);
    }

    public Address(String addressName, int addressNumber) {
        this.addressName = addressName;
        this.addressNumber = addressNumber;

    }

    public void addZipcode(Zipcode zipcode) {
        // add zipcode to Address
    }
}
