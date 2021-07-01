package com.restaurant.reservationApp.Payment;

import com.restaurant.reservationApp.employee.Employee;

import java.util.List;

public interface PaymentRepository {
    public List<Payment> getAllPayment();
    public Payment getPaymentById(long id);
    public Payment createPayment(Payment payment);
}
