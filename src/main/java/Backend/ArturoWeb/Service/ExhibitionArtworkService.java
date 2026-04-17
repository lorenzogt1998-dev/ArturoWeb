package Backend.ArturoWeb.Service;

import Backend.ArturoWeb.DTO.ExhibitionArtworkRequestDTO;
import Backend.ArturoWeb.DTO.ExhibitionArtworkResponseDTO;
import Backend.ArturoWeb.Entity.Artwork;
import Backend.ArturoWeb.Entity.Exhibition;
import Backend.ArturoWeb.Entity.ExhibitionArtwork;
import Backend.ArturoWeb.Mapper.ExhibitionArtworkMapper;
import Backend.ArturoWeb.Repository.ArtworkRepository;
import Backend.ArturoWeb.Repository.ExhibitionArtworkRepository;
import Backend.ArturoWeb.Repository.ExhibitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExhibitionArtworkService {

    private final ExhibitionArtworkRepository exhibitionArtworkRepository;
    private final ExhibitionRepository exhibitionRepository;
    private final ArtworkRepository artworkRepository;

    public ExhibitionArtworkService(ExhibitionArtworkRepository exhibitionArtworkRepository,
                                    ExhibitionRepository exhibitionRepository,
                                    ArtworkRepository artworkRepository) {
        this.exhibitionArtworkRepository = exhibitionArtworkRepository;
        this.exhibitionRepository = exhibitionRepository;
        this.artworkRepository = artworkRepository;
    }

    public ExhibitionArtworkResponseDTO createExhibitionArtwork(ExhibitionArtworkRequestDTO requestDTO) {
        Exhibition exhibition = exhibitionRepository.findById(requestDTO.exhibitionId())
                .orElseThrow(() -> new RuntimeException("Exhibition not found with id: " + requestDTO.exhibitionId()));

        Artwork artwork = artworkRepository.findById(requestDTO.artworkId())
                .orElseThrow(() -> new RuntimeException("Artwork not found with id: " + requestDTO.artworkId()));

        ExhibitionArtwork exhibitionArtwork = new ExhibitionArtwork();
        exhibitionArtwork.setExhibition(exhibition);
        exhibitionArtwork.setArtwork(artwork);

        ExhibitionArtwork savedExhibitionArtwork = exhibitionArtworkRepository.save(exhibitionArtwork);

        return ExhibitionArtworkMapper.toResponseDTO(savedExhibitionArtwork);
    }

    public List<ExhibitionArtworkResponseDTO> getAllExhibitionArtworks() {
        return exhibitionArtworkRepository.findAll()
                .stream()
                .map(ExhibitionArtworkMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ExhibitionArtworkResponseDTO getExhibitionArtworkById(Long id) {
        ExhibitionArtwork exhibitionArtwork = exhibitionArtworkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExhibitionArtwork not found with id: " + id));

        return ExhibitionArtworkMapper.toResponseDTO(exhibitionArtwork);
    }

    public void deleteExhibitionArtwork(Long id) {
        ExhibitionArtwork exhibitionArtwork = exhibitionArtworkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExhibitionArtwork not found with id: " + id));

        exhibitionArtworkRepository.delete(exhibitionArtwork);
    }
}