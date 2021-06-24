package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@SpringBootTest
class OrderTest {

	@Autowired
	IOrderService orderService;
	
	@Autowired
	ICustomerService customerService;
	
	@Test
	void testGuardarOrder() {
		Optional<Customer> cliente1 = customerService.getCustomerPorId(Long.valueOf(1));
		Order orden1 = new Order(Integer.valueOf(10100), LocalDate.of(2021, 6, 12), LocalDate.of(2021, 6, 24), LocalDate.of(2021, 6, 22), "Shipped", null, cliente1.get());
		orderService.guardarOrder(orden1);
		
		Order orden2 = new Order(Integer.valueOf(10102), LocalDate.of(2021, 6, 15), LocalDate.of(2021, 6, 24), LocalDate.of(2021, 6, 22), "Shipped", null, cliente1.get());
		orderService.guardarOrder(orden2);
		
		Optional<Customer> cliente2 = customerService.getCustomerPorId(Long.valueOf(5));
		Order orden3 = new Order(Integer.valueOf(10103), LocalDate.of(2021, 6, 19), LocalDate.of(2021, 6, 25), LocalDate.of(2021, 6, 20), "Shipped", null, cliente2.get());
		orderService.guardarOrder(orden3);
		
		Order orden4 = new Order(Integer.valueOf(10104), LocalDate.of(2021, 6, 18), LocalDate.of(2021, 6, 27), LocalDate.of(2021, 6, 23), "Shipped", null, cliente2.get());
		orderService.guardarOrder(orden4);
		
		Optional<Customer> cliente3 = customerService.getCustomerPorId(Long.valueOf(3));
		Order orden5 = new Order(Integer.valueOf(10105), LocalDate.of(2021, 6, 5), LocalDate.of(2021, 6, 26), LocalDate.of(2021, 6, 20), "Shipped", null, cliente3.get());
		orderService.guardarOrder(orden5);
		
		assertEquals(3, cliente3.get().idCliente);
		assertEquals(10105, orden5.getId());
	}

}
