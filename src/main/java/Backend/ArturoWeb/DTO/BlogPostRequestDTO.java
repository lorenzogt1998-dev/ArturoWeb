package Backend.ArturoWeb.DTO;

public record BlogPostRequestDTO(
        String title,
        String content,
        String imageUrl
) {
}