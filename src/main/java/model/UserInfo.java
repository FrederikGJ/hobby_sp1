package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.collection.spi.PersistentBag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_info_id", nullable = false)
    private int userInfoId;
    @Column (name = "user_name", length = 100)
    private String userName;

    @OneToOne
   @JoinColumn(name= "user_id") //Defines the foreign key column
    private User user;

    // One userName can have multiple ways of contact (private tlf, work tlf)
    @OneToMany (mappedBy = "userinfo", cascade = CascadeType.ALL, orphanRemoval = true)// bidirectional- Contact is owner. cascade = userInfo changes then Contact changes removal = orphaned Contacts are removed
    private Set<Contact> contactList = new HashSet<>();

    public UserInfo(String userName, User user, Set<Contact> contactList) {
        this.userName = userName;
        this.user = user;
        this.contactList = contactList;
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
        if(contact != null){
            contact.setPhonenumber(contact.getPhonenumber());
        }

    }
}
