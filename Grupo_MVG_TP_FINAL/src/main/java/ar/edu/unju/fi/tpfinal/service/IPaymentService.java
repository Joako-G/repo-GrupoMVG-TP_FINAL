package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Payment;

public interface IPaymentService {
	
	void guardarPayment(Payment payment);
	public List<Payment> getPayments();
}
