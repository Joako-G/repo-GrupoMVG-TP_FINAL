package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;
import ar.edu.unju.fi.tpfinal.repository.IPaymentRepository;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Service("paymentServiceMysql")
public class PaymentServiceMysqlImp implements IPaymentService {
	
	private static final Log LOGGER = LogFactory.getLog(PaymentServiceMysqlImp.class);

	@Autowired
	private IPaymentRepository paymentRepository;
	
	@Override
	public void guardarPayment(Payment payment) {
		paymentRepository.save(payment);
		LOGGER.info("METHOD: guardarPayment ---- Se agrego un objeto payment en la lista: " + payment);
	}

	@Override
	public List<Payment> getPayments() {
		List<Payment> payments = (List<Payment>) paymentRepository.findAll();
		return payments;
	}

	@Override
	public Optional<Payment> getPaymentPorId(PaymentId id) {
		Optional<Payment> payment = paymentRepository.findById(id);
		LOGGER.info("METHOD: getPaymentPorId ---- Se buscó un objeto payment en la lista: " + payment);
		return payment;
	}

	@Override
	public void eliminarPayment(PaymentId id) {
		paymentRepository.deleteById(id);
		LOGGER.info("METHOD: eliminarPayment ---- Se eliminó un objeto payment en la lista: " + "id cliente " + id.getCustomer().getIdCliente() + " - id cheque: " + id.getNumeroCheque());
	}

}
