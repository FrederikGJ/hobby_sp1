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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int userId;

    // one User only have one userName
    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    // bidicrectional -> userInfo is owner. cascade all = delete User also delets UserInfo
    private UserInfo userInfo;

    // multiple Users can have multiple hobbies
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Hobby> hobbies = new HashSet<>();

    // multiple Users can live on one Address
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id") // foreign key
    private Address address;


    public void addUserInfo(UserInfo userInfo) {
        if (userInfo != null) {
            this.userInfo = userInfo;
            userInfo.setUsers(this);
        }
    }

    public void addHobbies(Hobby hobby) {
        hobbies.add(hobby);
        if (hobby != null) {
            hobby.getUsers().add(this);
        }
    }

    public void addAddress(Address addresss) {
        this.address = addresss;
        if (addresss != null) {
            addresss.setUsers(this);
        }
    }


}
