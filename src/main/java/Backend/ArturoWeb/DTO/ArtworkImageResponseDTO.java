package Backend.ArturoWeb.DTO;
//cambios
public record ArtworkImageResponseDTO(
        Long id,
        String url,
        boolean isPrimary,
        Long artworkId
) {
}