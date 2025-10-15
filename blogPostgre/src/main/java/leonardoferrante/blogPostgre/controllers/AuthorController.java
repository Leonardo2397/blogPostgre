package leonardoferrante.blogPostgre.controllers;


import leonardoferrante.blogPostgre.entities.Author;
import leonardoferrante.blogPostgre.payload.NewAuthorPayload;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import leonardoferrante.blogPostgre.services.AuthorService;


import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    //chiamata get
    @GetMapping
    public List<Author> getAuthor() {
        return this.authorService.findAll();
    }

    // chiamata post
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody NewAuthorPayload body) {
        return this.authorService.saveAuthor(body);
    }

    // chiamata get ricerca per id
    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable long authorId) {
        return this.authorService.findById(authorId);
    }

    // chiamata put ricerc per id e modifica
    @PutMapping("/{authorId}")
    public Author getAuthorByIdAndUpdate(@PathVariable long authorId, @RequestBody NewAuthorPayload body) {
        return this.authorService.findByIdAndUpdate(authorId, body);
    }

    // chiamata delete ricerca per id e elimina
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getAuthorByIdAndDelete(@PathVariable long authorId) {
        this.authorService.findByIdAndDelete(authorId);
    }
}
