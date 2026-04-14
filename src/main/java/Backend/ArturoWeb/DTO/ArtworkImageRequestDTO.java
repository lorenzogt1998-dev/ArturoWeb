package Backend.ArturoWeb.DTO;

public record ArtworkImageRequestDTO(
        String url,
        boolean isPrimary,
        Long artworkId
) {
}