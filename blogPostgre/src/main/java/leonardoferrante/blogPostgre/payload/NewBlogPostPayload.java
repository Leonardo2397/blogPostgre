package leonardoferrante.blogPostgre.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewBlogPostPayload {
    private String category;
    private String title;
    private String content;
    private int lectureTime;
    private String cover;
}
