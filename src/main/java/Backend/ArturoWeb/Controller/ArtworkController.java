package Backend.ArturoWeb.Controller;
// cambios
import Backend.ArturoWeb.DTO.ArtworkRequestDTO;
import Backend.ArturoWeb.DTO.ArtworkResponseDTO;
import Backend.ArturoWeb.Entity.Artwork;
import Backend.ArturoWeb.Mapper.ArtworkMapper;
import Backend.ArturoWeb.Service.ArtworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artworks")
public class ArtworkController {

    private final ArtworkService artworkService;

    public ArtworkController(ArtworkService artworkService) {
        this.artworkService = artworkService;
    }

    @GetMapping
    public List<ArtworkResponseDTO> getAllArtworks() {
        return artworkService.getAllArtworks()
                .stream()
                .map(ArtworkMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtworkResponseDTO> getArtworkById(@PathVariable Long id) {
        return artworkService.getArtworkById(id)
                .map(artwork -> ResponseEntity.ok(ArtworkMapper.toDTO(artwork)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ArtworkResponseDTO createArtwork(@RequestBody ArtworkRequestDTO dto) {
        Artwork artwork = ArtworkMapper.toEntity(dto);
        Artwork savedArtwork = artworkService.createArtwork(artwork);
        return ArtworkMapper.toDTO(savedArtwork);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtworkResponseDTO> updateArtwork(@PathVariable Long id,
                                                            @RequestBody ArtworkRequestDTO dto) {
        try {
            Artwork artworkDetails = ArtworkMapper.toEntity(dto);
            Artwork updatedArtwork = artworkService.updateArtwork(id, artworkDetails);
            return ResponseEntity.ok(ArtworkMapper.toDTO(updatedArtwork));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtwork(@PathVariable Long id) {
        try {
            artworkService.deleteArtwork(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}