package Backend.ArturoWeb.Mapper;

import Backend.ArturoWeb.DTO.ArtworkRequestDTO;
import Backend.ArturoWeb.DTO.ArtworkResponseDTO;
import Backend.ArturoWeb.Entity.Artwork;

public class ArtworkMapper {

    public static Artwork toEntity(ArtworkRequestDTO dto) {
        Artwork artwork = new Artwork();
        artwork.setTitle(dto.title());
        artwork.setDescription(dto.description());
        artwork.setYear(dto.year());
        artwork.setTechnique(dto.technique());
        artwork.setImageUrl(dto.imageUrl());
        artwork.setCategoryId(dto.categoryId());
        return artwork;
    }

    public static ArtworkResponseDTO toDTO(Artwork artwork) {
        return new ArtworkResponseDTO(
                artwork.getId(),
                artwork.getTitle(),
                artwork.getDescription(),
                artwork.getYear(),
                artwork.getTechnique(),
                artwork.getImageUrl(),
                artwork.getCategoryId(),
                artwork.getCreatedAt()
        );
    }
}