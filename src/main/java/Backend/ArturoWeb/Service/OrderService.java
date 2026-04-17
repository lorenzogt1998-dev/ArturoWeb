package Backend.ArturoWeb.Service;

import Backend.ArturoWeb.DTO.OrderRequestDTO;
import Backend.ArturoWeb.DTO.OrderResponseDTO;
import Backend.ArturoWeb.Entity.Order;
import Backend.ArturoWeb.Entity.OrderItem;
import Backend.ArturoWeb.Mapper.OrderMapper;
import Backend.ArturoWeb.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponseDTO createOrder(OrderRequestDTO requestDTO) {
        if (requestDTO.items() == null || requestDTO.items().isEmpty()) {
            throw new RuntimeException("Order must contain at least one item");
        }

        Order order = new Order();
        order.setCreatedAt(LocalDateTime.now());

        List<OrderItem> items = requestDTO.items().stream().map(itemDTO -> {
            if (itemDTO.artworkId() == null) {
                throw new RuntimeException("Artwork id cannot be null");
            }
            if (itemDTO.price() == null || itemDTO.price().compareTo(BigDecimal.ZERO) < 0) {
                throw new RuntimeException("Price must be greater than or equal to zero");
            }
            if (itemDTO.quantity() == null || itemDTO.quantity() <= 0) {
                throw new RuntimeException("Quantity must be greater than zero");
            }

            OrderItem item = new OrderItem();
            item.setArtworkId(itemDTO.artworkId());
            item.setPrice(itemDTO.price());
            item.setQuantity(itemDTO.quantity());
            item.setOrder(order);
            return item;
        }).toList();

        order.setItems(items);

        BigDecimal total = items.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setTotal(total);

        Order savedOrder = orderRepository.save(order);

        return OrderMapper.toOrderResponseDTO(savedOrder);
    }

    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper::toOrderResponseDTO)
                .toList();
    }

    public OrderResponseDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        return OrderMapper.toOrderResponseDTO(order);
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with id: " + id);
        }

        orderRepository.deleteById(id);
    }
}