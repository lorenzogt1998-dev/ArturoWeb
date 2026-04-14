package Backend.ArturoWeb.DTO;

public record ArtworkImageResponseDTO(
        Long id,
        String url,
        boolean isPrimary,
        Long artworkId
) {
}