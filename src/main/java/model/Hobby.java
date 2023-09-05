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
public class Hobby{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int hobbyId;

    @Column(name = "name", nullable = false)
    private String hobbyName;

    @Enumerated (EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;

    //Slettet Type fra Jons data og erstattet den med category, da alle var var "General"


    public Hobby(String hobbyName, Category category) {
        this.hobbyName = hobbyName;
        this.category = category;
    }
}
