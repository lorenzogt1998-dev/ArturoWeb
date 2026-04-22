package Backend.ArturoWeb.Mapper;
//cambios
import Backend.ArturoWeb.DTO.ArtworkImageRequestDTO;
import Backend.ArturoWeb.DTO.ArtworkImageResponseDTO;
import Backend.ArturoWeb.Entity.ArtworkImage;

public class ArtworkImageMapper {

    public static ArtworkImage toEntity(ArtworkImageRequestDTO dto) {
        ArtworkImage artworkImage = new ArtworkImage();
        artworkImage.setUrl(dto.url());
        artworkImage.setPrimary(dto.isPrimary());
        return artworkImage;
    }

    public static ArtworkImageResponseDTO toDTO(ArtworkImage artworkImage) {
        return new ArtworkImageResponseDTO(
                artworkImage.getId(),
                artworkImage.getUrl(),
                artworkImage.isPrimary(),
                artworkImage.getArtwork() != null ? artworkImage.getArtwork().getId() : null
        );
    }
}