package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_info_id", nullable = false)
    private int userInfoId;
    @Column (name = "user_name", length = 100)
    private String userName;

    @OneToOne
   @JoinColumn(name= "user_info_id") //Defines the foreign key column
    private Users users;

    // One userName can have multiple ways of contact (private tlf, work tlf)
    @OneToMany (mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)// bidirectional- Contact is owner. cascade = userInfo changes then Contact changes removal = orphaned Contacts are removed
    private Set<Contact> contactList = new HashSet<>();

    public UserInfo(String userName) {
        this.userName = userName;
    }

    public void addContact(Contact contact) {
        this.contactList.add(contact);
        if(contact != null){
            contact.setUserInfo(this);
        }
    }
}
