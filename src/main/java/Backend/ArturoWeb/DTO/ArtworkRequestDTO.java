package Backend.ArturoWeb.DTO;

import java.util.Date;

public record ArtworkRequestDTO(
        String title,
        String description,
        Date year,
        String technique,
        String imageUrl,
        Long categoryId
) {
}