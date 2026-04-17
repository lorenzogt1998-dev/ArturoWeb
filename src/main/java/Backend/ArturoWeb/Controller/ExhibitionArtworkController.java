package Backend.ArturoWeb.Controller;

import Backend.ArturoWeb.DTO.ExhibitionArtworkRequestDTO;
import Backend.ArturoWeb.DTO.ExhibitionArtworkResponseDTO;
import Backend.ArturoWeb.Service.ExhibitionArtworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exhibition-artworks")
public class ExhibitionArtworkController {

    private final ExhibitionArtworkService exhibitionArtworkService;

    public ExhibitionArtworkController(ExhibitionArtworkService exhibitionArtworkService) {
        this.exhibitionArtworkService = exhibitionArtworkService;
    }

    @PostMapping
    public ResponseEntity<ExhibitionArtworkResponseDTO> createExhibitionArtwork(
            @RequestBody ExhibitionArtworkRequestDTO requestDTO) {
        ExhibitionArtworkResponseDTO responseDTO = exhibitionArtworkService.createExhibitionArtwork(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ExhibitionArtworkResponseDTO>> getAllExhibitionArtworks() {
        List<ExhibitionArtworkResponseDTO> exhibitionArtworks = exhibitionArtworkService.getAllExhibitionArtworks();
        return ResponseEntity.ok(exhibitionArtworks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExhibitionArtworkResponseDTO> getExhibitionArtworkById(@PathVariable Long id) {
        ExhibitionArtworkResponseDTO responseDTO = exhibitionArtworkService.getExhibitionArtworkById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExhibitionArtwork(@PathVariable Long id) {
        exhibitionArtworkService.deleteExhibitionArtwork(id);
        return ResponseEntity.ok("ExhibitionArtwork deleted successfully");
    }
}