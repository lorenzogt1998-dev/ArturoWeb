package Backend.ArturoWeb.Service;

import Backend.ArturoWeb.Entity.Exhibition;
import Backend.ArturoWeb.Repository.ExhibitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;

    public ExhibitionService(ExhibitionRepository exhibitionRepository) {
        this.exhibitionRepository = exhibitionRepository;
    }

    public List<Exhibition> getAllExhibitions() {
        return exhibitionRepository.findAll();
    }

    public Optional<Exhibition> getExhibitionById(Long id) {
        return exhibitionRepository.findById(id);
    }

    public Exhibition createExhibition(Exhibition exhibition) {
        return exhibitionRepository.save(exhibition);
    }

    public Exhibition updateExhibition(Long id, Exhibition exhibitionDetails) {
        Exhibition exhibition = exhibitionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exhibition not found with id: " + id));

        exhibition.setTitle(exhibitionDetails.getTitle());
        exhibition.setDescription(exhibitionDetails.getDescription());
        exhibition.setLocation(exhibitionDetails.getLocation());
        exhibition.setStartDate(exhibitionDetails.getStartDate());
        exhibition.setEndDate(exhibitionDetails.getEndDate());
        exhibition.setImageUrl(exhibitionDetails.getImageUrl());

        return exhibitionRepository.save(exhibition);
    }

    public void deleteExhibition(Long id) {
        exhibitionRepository.deleteById(id);
    }
}