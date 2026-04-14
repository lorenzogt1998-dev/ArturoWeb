package Backend.ArturoWeb.Repository;

import Backend.ArturoWeb.Entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}