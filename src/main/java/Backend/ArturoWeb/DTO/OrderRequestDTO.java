package Backend.ArturoWeb.DTO;

import java.util.List;

public record OrderRequestDTO(
        List<OrderItemRequestDTO> items
) {}