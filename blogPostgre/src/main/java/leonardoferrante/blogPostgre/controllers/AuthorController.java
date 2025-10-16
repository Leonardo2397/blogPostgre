package leonardoferrante.blogPostgre.controllers;


import leonardoferrante.blogPostgre.entities.Author;
import leonardoferrante.blogPostgre.payload.NewAuthorPayload;
import leonardoferrante.blogPostgre.services.CloudinaryService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import leonardoferrante.blogPostgre.services.AuthorService;

import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public Author createAuthor(@RequestBody @Valid NewAuthorPayload body) {
        return this.authorService.saveAuthor(body);
    }

    // chiamata get ricerca per id
    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable long authorId) {
        return this.authorService.findById(authorId);
    }

    // chiamata put ricerc per id e modifica
    @PutMapping("/{authorId}")
    public Author getAuthorByIdAndUpdate(@PathVariable long authorId, @RequestBody @Valid NewAuthorPayload body) {
        return this.authorService.findByIdAndUpdate(authorId, body);
    }

    // chiamata delete ricerca per id e elimina
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getAuthorByIdAndDelete(@PathVariable long authorId) {
        this.authorService.findByIdAndDelete(authorId);
    }

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("{authorId}/avatar")
    public Author uploadAvatar(
            @PathVariable long authorId,
            @RequestParam("file")MultipartFile file
            ) throws IOException {
        String url = cloudinaryService.upload(file);
        Author author = this.authorService.findById(authorId);
        author.setAvatar(url);
        return this.authorService.findByIdAndUpdate(authorId, new leonardoferrante.blogPostgre.payload.NewAuthorPayload(
                author.getName(), author.getSurname(), author.getEmail(), author.getPassword(), author.getAge(), url));
    }
}
