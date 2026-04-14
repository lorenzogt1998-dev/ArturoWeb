package Backend.ArturoWeb.DTO;

public record ArtistResponseDTO(
        Long id,
        String name,
        String biography,
        String profileImage,
        String instagram,
        String email
) {
}