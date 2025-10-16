package leonardoferrante.blogPostgre.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class NewAuthorPayload {

    @NotBlank(message = "Il nome è obbligatorio")
    private String name;

    @NotBlank(message = "Il cognome è obbligatorio")
    private String surname;

    @NotBlank(message = "la mail è obbligatoria")
    @NotBlank(message = "la mail non è valida")
    private String email;

    @NotBlank(message = "la pw è obbligatoria")
    @NotBlank(message = "la pw è errata")
    private String password;

    @Min(value= 0, message = "l eta deve essere un numero positivo")
    private int age;


    private String avatar;
}

