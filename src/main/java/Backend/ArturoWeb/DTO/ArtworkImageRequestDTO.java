package Backend.ArturoWeb.DTO;
//cambios
public record ArtworkImageRequestDTO(
        String url,
        boolean isPrimary,
        Long artworkId
) {
}