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
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phonenumber", nullable = false)
    private int phonenumber;

    @ManyToOne
    @JoinColumn(name ="user_info_id") // foreign key column
    private UserInfo userInfo;

    public Contact(int phonenumber) {
        this.phonenumber = phonenumber;

    }

}
