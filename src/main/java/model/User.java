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

    // one User have one userName
   @OneToOne
    private  UserInfo userInfo;

   // multiple Users can have multiple hobbies
   @ManyToMany(mappedBy = "users")
    private Set<Hobby> hobbies = new HashSet<>();

   // multiple Users can live on one Address
   @ManyToOne
    private Address address;

    public User(UserInfo userInfo, Set<Hobby> hobbies, Address address) {
        this.userInfo = userInfo;
        this.hobbies = hobbies;
        this.address = address;
    }

    public void addUserInfo(UserInfo userInfo) {
        userInfo.setContactList(userInfo.getContactList());
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
