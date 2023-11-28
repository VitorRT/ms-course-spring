package com.example.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.entities.Worker;
import com.example.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	private WorkerFeignClient workerFeignClient;
	
	public PaymentService(WorkerFeignClient workerFeignClient) {
		this.workerFeignClient = workerFeignClient;
	}
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
