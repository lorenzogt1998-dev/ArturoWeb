package Backend.ArturoWeb.Service;

import Backend.ArturoWeb.Entity.Artwork;
import Backend.ArturoWeb.Repository.ArtworkRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArtworkService {

    private final ArtworkRepository artworkRepository;

    public ArtworkService(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    public List<Artwork> getAllArtworks() {
        return artworkRepository.findAll();
    }

    public Optional<Artwork> getArtworkById(Long id) {
        return artworkRepository.findById(id);
    }

    public Artwork createArtwork(Artwork artwork) {
        artwork.setCreatedAt(new Date());
        return artworkRepository.save(artwork);
    }

    public Artwork updateArtwork(Long id, Artwork artworkDetails) {
        Artwork artwork = artworkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artwork no encontrado con id: " + id));

        artwork.setTitle(artworkDetails.getTitle());
        artwork.setDescription(artworkDetails.getDescription());
        artwork.setYear(artworkDetails.getYear());
        artwork.setTechnique(artworkDetails.getTechnique());
        artwork.setImageUrl(artworkDetails.getImageUrl());
        artwork.setCategoryId(artworkDetails.getCategoryId());

        return artworkRepository.save(artwork);
    }

    public void deleteArtwork(Long id) {
        Artwork artwork = artworkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artwork no encontrado con id: " + id));

        artworkRepository.delete(artwork);
    }
}