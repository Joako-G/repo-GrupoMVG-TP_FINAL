package ar.edu.unju.fi.tpfinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.repository.IPaymentRepository;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Service("paymentServiceMysql")
public class PaymentServiceMysqlImp implements IPaymentService {

	@Autowired
	private IPaymentRepository paymentRepository;
	
	@Override
	public void guardarPayment(Payment payment) {
		paymentRepository.save(payment);

	}

}
