package Backend.ArturoWeb.DTO;

import java.util.Date;

public record EventResponseDTO(
        Long id,
        String title,
        String description,
        String location,
        Date date,
        String imageUrl
) {
}