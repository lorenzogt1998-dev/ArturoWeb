package Backend.ArturoWeb.Repository;

import Backend.ArturoWeb.Entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}