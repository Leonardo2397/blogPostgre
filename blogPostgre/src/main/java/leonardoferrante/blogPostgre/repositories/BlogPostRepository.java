package leonardoferrante.blogPostgre.repositories;

import leonardoferrante.blogPostgre.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
