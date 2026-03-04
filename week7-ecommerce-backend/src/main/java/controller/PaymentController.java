package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enums.OrderStatus;
import enums.PaymentStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import model.entity.Order;
import model.entity.Payment;
import repository.OrderRepository;
import repository.PaymentRepository;
@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentRepository paymentRepository = null;
    private final OrderRepository orderRepository = null;

    // Make payment for an order
    @PostMapping("/{orderId}")
    @Transactional
    public ResponseEntity<Payment> makePayment(@PathVariable Long orderId) {

        jakarta.persistence.criteria.Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (((Object) order).getStatus() != OrderStatus.CREATED) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(((Object) order).getTotalAmount());
        payment.setStatus(PaymentStatus.SUCCESS);

        ((Payment) order).setStatus(OrderStatus.PAID);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentRepository.save(payment));
    }

    // Get all payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payment by order ID
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Payment> getPaymentByOrderId(@PathVariable Long orderId) {
        return paymentRepository.findById(orderId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}