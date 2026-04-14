package Backend.ArturoWeb.Controller;
// cambios
import Backend.ArturoWeb.DTO.ArtworkImageRequestDTO;
import Backend.ArturoWeb.DTO.ArtworkImageResponseDTO;
import Backend.ArturoWeb.Service.ArtworkImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artwork-images")
public class ArtworkImageController {

    private final ArtworkImageService artworkImageService;

    public ArtworkImageController(ArtworkImageService artworkImageService) {
        this.artworkImageService = artworkImageService;
    }

    @GetMapping
    public List<ArtworkImageResponseDTO> getAllArtworkImages() {
        return artworkImageService.getAllArtworkImages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtworkImageResponseDTO> getArtworkImageById(@PathVariable Long id) {
        return artworkImageService.getArtworkImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ArtworkImageResponseDTO createArtworkImage(@RequestBody ArtworkImageRequestDTO dto) {
        return artworkImageService.createArtworkImage(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtworkImageResponseDTO> updateArtworkImage(@PathVariable Long id,
                                                                      @RequestBody ArtworkImageRequestDTO dto) {
        try {
            ArtworkImageResponseDTO updatedArtworkImage = artworkImageService.updateArtworkImage(id, dto);
            return ResponseEntity.ok(updatedArtworkImage);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtworkImage(@PathVariable Long id) {
        artworkImageService.deleteArtworkImage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/artwork/{artworkId}")
    public List<ArtworkImageResponseDTO> getImagesByArtworkId(@PathVariable Long artworkId) {
        return artworkImageService.getImagesByArtworkId(artworkId);
    }
}