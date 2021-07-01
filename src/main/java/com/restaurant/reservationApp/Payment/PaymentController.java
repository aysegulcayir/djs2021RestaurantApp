package com.restaurant.reservationApp.Payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PaymentController {
    PaymentService paymentService;
    public PaymentController(){
    }

    @Autowired
    public PaymentController (PaymentService paymentService){this.paymentService = paymentService;}

    @GetMapping("/payment")
    public ResponseEntity<List<Payment>> getAllPayment() {
        List<Payment> allPayment = paymentService.getAllPayment();
        return new ResponseEntity<>(allPayment, HttpStatus.OK);
    }
    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable(name = "id", required = true) long id) {
        Payment payment = paymentService.getPaymentById(id);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @PutMapping(value = "/payment", produces = "application/json",consumes = "application/json")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment){
        Payment payment1 = paymentService.createPayment(payment);
        return new ResponseEntity<>(payment1, HttpStatus.OK);
    }
}
