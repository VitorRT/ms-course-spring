package com.example.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	private PaymentService paymentService;
	
	public PaymentResource(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = paymentService.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
}
