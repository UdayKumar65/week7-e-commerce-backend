package service;

import java.util.List;

import model.dto.OrderDTO;
import model.entity.Order;

public interface OrderService {

    Order placeOrder(OrderDTO orderDTO);

    Order getOrderById(Long orderId);

    List<Order> getOrdersByUser(Long userId);

    void cancelOrder(Long orderId);

	jakarta.persistence.criteria.Order createOrder(Long userId);
}