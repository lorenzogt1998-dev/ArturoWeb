package Backend.ArturoWeb.Controller;

import Backend.ArturoWeb.Entity.Exhibition;
import Backend.ArturoWeb.Service.ExhibitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exhibitions")
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    public ExhibitionController(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    @GetMapping
    public List<Exhibition> getAllExhibitions() {
        return exhibitionService.getAllExhibitions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exhibition> getExhibitionById(@PathVariable Long id) {
        return exhibitionService.getExhibitionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Exhibition createExhibition(@RequestBody Exhibition exhibition) {
        return exhibitionService.createExhibition(exhibition);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exhibition> updateExhibition(@PathVariable Long id,
                                                       @RequestBody Exhibition exhibitionDetails) {
        try {
            Exhibition updatedExhibition = exhibitionService.updateExhibition(id, exhibitionDetails);
            return ResponseEntity.ok(updatedExhibition);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExhibition(@PathVariable Long id) {
        exhibitionService.deleteExhibition(id);
        return ResponseEntity.noContent().build();
    }
}