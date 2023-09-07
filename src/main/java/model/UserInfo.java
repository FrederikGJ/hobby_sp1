package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @Temporal (TemporalType.TIMESTAMP)
    @Column (name ="created_date", nullable = false)
    private LocalDateTime createdDate;

    @Temporal (TemporalType.TIMESTAMP)
    @Column (name ="updated_date", nullable = false)
    private LocalDateTime updatedDate;
    @PrePersist // This method will be called before the entity is persisted -  does not require manual intervention when UserInfo is changed
    protected void onCreate() {
        LocalDateTime date = LocalDateTime.now();
        this.createdDate = date;
        this.updatedDate = date;

    }
    @PreUpdate // This methods will be called before the entity is updated and merged -  does not require manual intervention when UserInfo is changed
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }

    @OneToOne
    private Users users;

    // One userName can have multiple ways of contact (private tlf, work tlf)
    @OneToMany (mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)// bidirectional- Contact is owner. cascade = userInfo changes then Contact changes removal = orphaned Contacts are removed
    private Set<Contact> contactList = new HashSet<>();

    public UserInfo(String userName, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.userName = userName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

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
