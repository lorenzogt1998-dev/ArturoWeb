package Backend.ArturoWeb.DTO;

import java.math.BigDecimal;

public record OrderItemRequestDTO(
        Long artworkId,
        BigDecimal price,
        Integer quantity
) {}