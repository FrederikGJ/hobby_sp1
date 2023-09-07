package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Contact {
    @Id
    @Column(name = "phonenumber", nullable = false)
    private int phonenumber;

    @ManyToOne
    @JoinColumn(name ="user_info_id") // foreign key column
    private UserInfo userInfo;

    @PrePersist
    public void  validatePhoneNumber() throws IllegalAccessException {
        String phonenumberRegEx = "\\d{8}";
        Pattern pattern = Pattern.compile(phonenumberRegEx); // compile pattern
        Matcher matcher = pattern.matcher(String.valueOf(phonenumber)); // check matches to pattern
         if (!matcher.matches()){
             throw new IllegalAccessException("Invalid Phonenumber");
         }


    }


    public Contact(int phonenumber) {
        this.phonenumber = phonenumber;

    }

    @Override
    public String toString() {
        return "Contact phonenumber: " + phonenumber + "\n";
    }
}
