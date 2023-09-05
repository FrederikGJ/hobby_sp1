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
public class Hobby{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int hobbyId;

    @Column(name = "name", nullable = false)
    private String hobbyName;

   // multiple Hobbies can be under the same Category
    @Enumerated (EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;

    // multiple Users can have multiple Hobbies
    @ManyToMany
    private Set<User> users = new HashSet<>();

    public Hobby(String hobbyName, Category category, Set<User> users) {
        this.hobbyName = hobbyName;
        this.category = category;
        this.users = users;
    }

}
