package Backend.ArturoWeb.Repository;

import Backend.ArturoWeb.Entity.ArtworkImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtworkImageRepository extends JpaRepository<ArtworkImage, Long> {

    List<ArtworkImage> findByArtworkId(Long artworkId);
}