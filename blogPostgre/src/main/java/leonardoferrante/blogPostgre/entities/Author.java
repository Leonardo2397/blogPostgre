package leonardoferrante.blogPostgre.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Random;


@Entity
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private int age;
    private String avatar;

    public Author(String name, String surname, String email, String password, int age) {
        Random rndm = new Random();
       // this.id = rndm.nextInt(1, 10000);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.age= age;
        this.avatar =  "https://ui-avatars.com/api/?name=" +  "&background=random&color=fff";
    }
}