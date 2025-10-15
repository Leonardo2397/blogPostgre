package leonardoferrante.blogPostgre.services;


import leonardoferrante.blogPostgre.entities.Author;
import leonardoferrante.blogPostgre.exceptions.NotFoundExceptions;
import leonardoferrante.blogPostgre.payload.NewAuthorPayload;
import leonardoferrante.blogPostgre.repositories.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
    return authorRepository.findAll();
    }

    public Author saveAuthor(NewAuthorPayload payload) {
        Author newAuthor= new Author();
        newAuthor.setName(payload.getName());
        newAuthor.setSurname(payload.getSurname());
        newAuthor.setEmail(payload.getEmail());
        newAuthor.setPassword(payload.getPassword());
        newAuthor.setAge(payload.getAge());
        newAuthor.setAvatar("https://ui-avatars.com/api/?name=" + payload.getName() + "&background=random&color=fff");
        return authorRepository.save(newAuthor);
    }
    public Author findById(long authorId) {
        return authorRepository.findById(authorId).orElseThrow(() -> new NotFoundExceptions(authorId));
    }

    public Author findByIdAndUpdate(long authorId, NewAuthorPayload payload) {
        Author found = findById(authorId);
        found.setName(payload.getName());
        found.setSurname(payload.getSurname());
        found.setEmail(payload.getEmail());
        found.setPassword(payload.getPassword());
        found.setAge(payload.getAge());
        return authorRepository.save(found);
    }

    public void findByIdAndDelete(long authorId) {
        Author found = findById(authorId);
        authorRepository.delete(found);
    }

}


//   // private List<Author> authorDB = new ArrayList<>();
//
//    public List<Author> findAll() {
//        return this.authorDB;
//    }
//
//    public Author saveAuthor(NewAuthorPayload payload) {
//        Author newAuthor = new Author(payload.getName(), payload.getSurname(), payload.getEmail(), payload.getPassword(), payload.getAge());
//        this.authorDB.add(newAuthor);
//        log.info("l'utente con email " + newAuthor.getEmail() + "è stato aggiunto");
//        return newAuthor;
//    }
//
//    public Author findById(long authorId) {
//        Author found = null;
//        for ( Author author: this.authorDB) {
//            if(author.getId() == authorId) found = author;
//        }
//        if (found == null) throw new NotFoundExceptions(authorId);
//        return found;
//    }
//
//    public Author findByIdAndUpdate(long authorId, NewAuthorPayload payload) {
//        Author found = null;
//        for (Author author : this.authorDB) {
//            if (author.getId() == authorId) {
//                found = author;
//                found.setName(payload.getName());
//                found.setSurname(payload.getSurname());
//                found.setEmail(payload.getEmail());
//                found.setPassword(payload.getPassword());
//                found.setAge(payload.getAge());
//            }
//        }
//        if(found == null) throw new NotFoundExceptions(authorId);
//        return found;
//    }
//
//    public void findByIdAndDelete(long authorId) {
//        Author found= null;
//        for (Author author : this.authorDB) {
//            if (author.getId() == authorId) found = author;
//        }
//        if (found == null) throw new NotFoundExceptions(authorId);
//        this.authorDB.remove(found);
//    }
//}
