package model.dto;

import java.util.List;

import enums.OrderStatus;
import lombok.Data;

@Data
public class OrderDTO {

    private Long orderId;
    private Long userId;

    private OrderStatus status;
    private Double totalAmount;

    // Product ID + quantity mapping
    private List<OrderItemDTO> items;

    @Data
    public static class OrderItemDTO {
        private Long productId;
        private Integer quantity;
    }
}