package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@SpringBootTest
class PaymentTest {

	@Autowired
	IPaymentService paymentService;
	
	@Autowired
	ICustomerService customerService;
	
	@Test
	void testGuardarPayment() {
		Optional<Customer> cliente1 = customerService.getCustomerPorId(Long.valueOf(1));
		
		assertEquals(1, cliente1.get().idCliente);
		
		PaymentId id1 = new PaymentId(cliente1.get(), "HQ336336");
		Payment pago1 = new Payment(id1, LocalDate.of(2021, 6, 17), BigDecimal.valueOf(6066.78));
		paymentService.guardarPayment(pago1);
		
		PaymentId id2 = new PaymentId(cliente1.get(), "JM555205");
		Payment pago2 = new Payment(id2, LocalDate.of(2021, 6, 20), BigDecimal.valueOf(14571.44));
		paymentService.guardarPayment(pago2);
		
		
		Optional<Customer> cliente2 = customerService.getCustomerPorId(Long.valueOf(2));
		
		PaymentId id3 = new PaymentId(cliente2.get(), "BO864823");
		Payment pago3 = new Payment(id3, LocalDate.of(2021, 6, 18), BigDecimal.valueOf(1676.14));
		paymentService.guardarPayment(pago3);
		
		PaymentId id4 = new PaymentId(cliente2.get(), "OM314933");
		Payment pago4 = new Payment(id4, LocalDate.of(2021, 6, 15), BigDecimal.valueOf(32641.98));
		paymentService.guardarPayment(pago4);
		
		PaymentId id5 = new PaymentId(cliente2.get(), "HQ55022");
		Payment pago5 = new Payment(id5, LocalDate.of(2021, 6, 2), BigDecimal.valueOf(33347.88));
		paymentService.guardarPayment(pago5);
		
		assertEquals("HQ55022",pago5.getId().getNumeroCheque());
	}

}
