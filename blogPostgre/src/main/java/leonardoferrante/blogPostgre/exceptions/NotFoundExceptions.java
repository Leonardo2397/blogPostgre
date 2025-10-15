package leonardoferrante.blogPostgre.exceptions;

public class NotFoundExceptions extends RuntimeException{
    public NotFoundExceptions(long id) {
        super("la risorsa con id " + id + "non è stata trovata!");
    }
}
