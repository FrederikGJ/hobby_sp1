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

    public Address(String addressName, int addressNumber) {
        this.addressName = addressName;
        this.addressNumber = addressNumber;

    }
}
