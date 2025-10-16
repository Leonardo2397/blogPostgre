package leonardoferrante.blogPostgre.payload;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewBlogPostPayload {

    @NotBlank(message = "la categoria è obbligatoria")
    private String category;

    @NotBlank(message = "Il titolo è obbligatorio")
    @Size(min = 3, message = "il titolo deve avere almeno 3 caratteri")
    private String title;

    @NotBlank(message = "Il contenuto è obbligatorio")
    private String content;
    private int lectureTime;
    private String cover;
}
