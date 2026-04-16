package Backend.ArturoWeb.DTO;

import java.util.Date;

public record BlogPostResponseDTO(
        Long id,
        String title,
        String content,
        String imageUrl,
        Date createdAt
) {
}