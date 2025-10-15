package leonardoferrante.blogPostgre.services;

import leonardoferrante.blogPostgre.entities.BlogPost;
import leonardoferrante.blogPostgre.exceptions.NotFoundExceptions;
import leonardoferrante.blogPostgre.payload.NewBlogPostPayload;
import leonardoferrante.blogPostgre.repositories.BlogPostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }

    public BlogPost saveBlogPost(NewBlogPostPayload payload) {
        BlogPost newBlogPost = new BlogPost();
        newBlogPost.setCategory(payload.getCategory());
        newBlogPost.setTitle(payload.getTitle());
        newBlogPost.setContent(payload.getContent());
        newBlogPost.setLectureTime(payload.getLectureTime());
        newBlogPost.setCover("https://picsum.photos/200/300");
        return blogPostRepository.save(newBlogPost);
    }

    public BlogPost findById(long blogPostId) {
        return blogPostRepository.findById(blogPostId)
                .orElseThrow(() -> new NotFoundExceptions(blogPostId));
    }

    public BlogPost findByIdAndUpdate(long blogPostId, NewBlogPostPayload payload) {
        BlogPost found = findById(blogPostId);
        found.setCategory(payload.getCategory());
        found.setTitle(payload.getTitle());
        found.setContent(payload.getContent());
        found.setLectureTime(payload.getLectureTime());
        return blogPostRepository.save(found);
    }

    public void findByIdAndDelete(long blogPostId) {
        BlogPost found = findById(blogPostId);
        blogPostRepository.delete(found);
    }
}
