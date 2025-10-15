package leonardoferrante.blogPostgre.controllers;


import leonardoferrante.blogPostgre.entities.BlogPost;
import leonardoferrante.blogPostgre.payload.NewBlogPostPayload;
import leonardoferrante.blogPostgre.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    //chiamata get
    @GetMapping
    public List<BlogPost> getBlogPost() {
        return this.blogPostService.findAll();
    }

    //chiamata post
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost createBlogPost(@RequestBody NewBlogPostPayload body) {
        return this.blogPostService.saveBlogPost(body);
    }

    //get ricerca id
    @GetMapping("/{blogPostId}")
    public BlogPost getBlogPostById(@PathVariable long blogPostId) {
        return this.blogPostService.findById(blogPostId);
    }

    //put per modifica
    @PutMapping("/{blogPostId}")
    public BlogPost getBlogPostByIdAndupdate(
            @PathVariable long blogPostId,
            @RequestBody NewBlogPostPayload body
    ) {
        return blogPostService.findByIdAndUpdate(blogPostId, body);
    }


    //delete per eliminare
    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getBlogPostByIdAndDelete(@PathVariable long blogPostId) {
        this.blogPostService.findByIdAndDelete(blogPostId);
    }
}
