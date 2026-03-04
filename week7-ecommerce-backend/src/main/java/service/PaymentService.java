package service;

import java.util.List;

import model.entity.Payment;

public interface PaymentService {

    Payment processPayment(Long orderId);

    Payment getPaymentByOrderId(Long orderId);

    List<Payment> getAllPayments();
}