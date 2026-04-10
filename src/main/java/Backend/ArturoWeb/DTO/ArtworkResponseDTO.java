package Backend.ArturoWeb.DTO;

import java.util.Date;

public record ArtworkResponseDTO(
        Long id,
        String title,
        String description,
        Date year,
        String technique,
        String imageUrl,
        Long categoryId,
        Date createdAt
) {
}