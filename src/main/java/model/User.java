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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int userId;

    // one User only have one userName
   @OneToOne (mappedBy = "user", cascade = CascadeType.ALL)
   // bidicrectional -> userInfo is owner. cascade all = delete User also delets UserInfo
    private  UserInfo userInfo;

   // multiple Users can have multiple hobbies
   @ManyToMany(mappedBy = "users")
    private Set<Hobby> hobbies = new HashSet<>();

   // multiple Users can live on one Address
   @ManyToOne
   @JoinColumn(name = "address_id") // foreign key
    private Address address;

    public User(UserInfo userInfo, Set<Hobby> hobbies, Address address) {
        this.userInfo = userInfo;
        this.hobbies = hobbies;
        this.address = address;
    }

    public void addUserInfo(UserInfo userInfo) {
        userInfo.setUserName(userInfo.getUserName());
        }

    public void addHobbies(Hobby hobby)
    {
        hobbies.add(hobby);
        if (hobby != null)
        {
            hobby.getUsers().add(this);
        }
    }

}
