package Backend.ArturoWeb.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponseDTO(
        Long id,
        LocalDateTime createdAt,
        BigDecimal total,
        List<OrderItemResponseDTO> items
) {}