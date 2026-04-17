package Backend.ArturoWeb.Repository;

import Backend.ArturoWeb.Entity.ExhibitionArtwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitionArtworkRepository extends JpaRepository<ExhibitionArtwork, Long> {
}