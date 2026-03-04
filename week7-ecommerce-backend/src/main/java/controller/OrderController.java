package controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import service.OrderService;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService = null;

    @PostMapping("/{userId}")
    public Order create(@PathVariable Long userId) {
        return orderService.createOrder(userId);
    }
}