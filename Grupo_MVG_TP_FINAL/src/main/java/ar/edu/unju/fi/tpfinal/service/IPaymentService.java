package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;

public interface IPaymentService {
	
	void guardarPayment(Payment payment);
	public List<Payment> getPayments();
	public Optional<Payment> getPaymentPorId(PaymentId id);
	public boolean existPaymentByCustomer(Long customerId);
	public void eliminarPayment(PaymentId id);
	
}
