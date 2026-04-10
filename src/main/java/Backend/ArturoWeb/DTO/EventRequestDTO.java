package Backend.ArturoWeb.DTO;

import java.util.Date;

public record EventRequestDTO(
        String title,
        String description,
        String location,
        Date date,
        String imageUrl
) {
}