package leonardoferrante.blogPostgre.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Random;


@Entity
@Table(name = "blogPosts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;


    private String category;
    private String title;
    private String content;
    private int lectureTime;
    public String cover;

    public BlogPost(String category, String title, String content, int lectureTime) {
        Random rndm = new Random();
       // this.id=rndm.nextInt(10000,1000000000);
        this.category=category;
        this.title=title;
        this.content=content;
        this.lectureTime=rndm.nextInt(3,40);
        this.cover= "https://picsum.photos/200/300";
    }

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
