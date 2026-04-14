package Backend.ArturoWeb.Controller;

import Backend.ArturoWeb.DTO.ArtistRequestDTO;
import Backend.ArturoWeb.DTO.ArtistResponseDTO;
import Backend.ArturoWeb.Service.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<ArtistResponseDTO> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistResponseDTO> getArtistById(@PathVariable Long id) {
        return artistService.getArtistById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ArtistResponseDTO createArtist(@RequestBody ArtistRequestDTO dto) {
        return artistService.createArtist(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistResponseDTO> updateArtist(@PathVariable Long id,
                                                          @RequestBody ArtistRequestDTO dto) {
        try {
            ArtistResponseDTO updatedArtist = artistService.updateArtist(id, dto);
            return ResponseEntity.ok(updatedArtist);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return ResponseEntity.noContent().build();
    }
}