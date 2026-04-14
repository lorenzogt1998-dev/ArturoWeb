package Backend.ArturoWeb.Service;

import Backend.ArturoWeb.DTO.ArtworkImageRequestDTO;
import Backend.ArturoWeb.DTO.ArtworkImageResponseDTO;
import Backend.ArturoWeb.Entity.Artwork;
import Backend.ArturoWeb.Entity.ArtworkImage;
import Backend.ArturoWeb.Mapper.ArtworkImageMapper;
import Backend.ArturoWeb.Repository.ArtworkImageRepository;
import Backend.ArturoWeb.Repository.ArtworkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtworkImageService {

    private final ArtworkImageRepository artworkImageRepository;
    private final ArtworkRepository artworkRepository;

    public ArtworkImageService(ArtworkImageRepository artworkImageRepository, ArtworkRepository artworkRepository) {
        this.artworkImageRepository = artworkImageRepository;
        this.artworkRepository = artworkRepository;
    }

    public List<ArtworkImageResponseDTO> getAllArtworkImages() {
        return artworkImageRepository.findAll()
                .stream()
                .map(ArtworkImageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ArtworkImageResponseDTO> getArtworkImageById(Long id) {
        return artworkImageRepository.findById(id)
                .map(ArtworkImageMapper::toDTO);
    }

    public ArtworkImageResponseDTO createArtworkImage(ArtworkImageRequestDTO dto) {
        Artwork artwork = artworkRepository.findById(dto.artworkId())
                .orElseThrow(() -> new RuntimeException("Artwork no encontrado con id: " + dto.artworkId()));

        ArtworkImage artworkImage = ArtworkImageMapper.toEntity(dto);
        artworkImage.setArtwork(artwork);

        ArtworkImage savedArtworkImage = artworkImageRepository.save(artworkImage);

        return ArtworkImageMapper.toDTO(savedArtworkImage);
    }

    public ArtworkImageResponseDTO updateArtworkImage(Long id, ArtworkImageRequestDTO dto) {
        return artworkImageRepository.findById(id).map(artworkImage -> {
            artworkImage.setUrl(dto.url());
            artworkImage.setPrimary(dto.isPrimary());

            if (dto.artworkId() != null) {
                Artwork artwork = artworkRepository.findById(dto.artworkId())
                        .orElseThrow(() -> new RuntimeException("Artwork no encontrado con id: " + dto.artworkId()));
                artworkImage.setArtwork(artwork);
            }

            ArtworkImage updatedArtworkImage = artworkImageRepository.save(artworkImage);
            return ArtworkImageMapper.toDTO(updatedArtworkImage);
        }).orElseThrow(() -> new RuntimeException("ArtworkImage no encontrada con id: " + id));
    }

    public void deleteArtworkImage(Long id) {
        artworkImageRepository.deleteById(id);
    }

    public List<ArtworkImageResponseDTO> getImagesByArtworkId(Long artworkId) {
        return artworkImageRepository.findByArtworkId(artworkId)
                .stream()
                .map(ArtworkImageMapper::toDTO)
                .collect(Collectors.toList());
    }
}