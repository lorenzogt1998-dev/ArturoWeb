package Backend.ArturoWeb.Mapper;

import Backend.ArturoWeb.DTO.OrderItemResponseDTO;
import Backend.ArturoWeb.DTO.OrderResponseDTO;
import Backend.ArturoWeb.Entity.Order;
import Backend.ArturoWeb.Entity.OrderItem;

import java.util.List;

public class OrderMapper {

    public static OrderItemResponseDTO toOrderItemResponseDTO(OrderItem orderItem) {
        return new OrderItemResponseDTO(
                orderItem.getId(),
                orderItem.getArtworkId(),
                orderItem.getPrice(),
                orderItem.getQuantity()
        );
    }

    public static OrderResponseDTO toOrderResponseDTO(Order order) {
        List<OrderItemResponseDTO> items = order.getItems()
                .stream()
                .map(OrderMapper::toOrderItemResponseDTO)
                .toList();

        return new OrderResponseDTO(
                order.getId(),
                order.getCreatedAt(),
                order.getTotal(),
                items
        );
    }
}