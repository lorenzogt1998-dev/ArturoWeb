package Backend.ArturoWeb.DTO;

public record ArtistRequestDTO(
        String name,
        String biography,
        String profileImage,
        String instagram,
        String email
) {
}