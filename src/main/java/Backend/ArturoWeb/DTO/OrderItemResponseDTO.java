package Backend.ArturoWeb.DTO;

import java.math.BigDecimal;

public record OrderItemResponseDTO(
        Long id,
        Long artworkId,
        BigDecimal price,
        Integer quantity
) {}