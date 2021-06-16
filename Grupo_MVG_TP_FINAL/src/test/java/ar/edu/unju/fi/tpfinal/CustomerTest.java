package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;


@SpringBootTest
class CustomerTest {

		@Autowired
		@Qualifier("customerServiceImpMysql")
		private ICustomerService customerService;
		
		@Test
		void test() {
			Customer cliente1 = new Customer(Long.valueOf(5), "Nisan","Palacios", "Gustabo", "+(54)388-3422212", "Av Catalan n°332 ", "Lavalle 365", "San Salvador de Jujuy", "Dr. Manuel Belgrano", "4600", "Argentina", null, null, null, null);
			customerService.guardarCustomer(cliente1);
			assertEquals(5,cliente1.getIdCliente());
		}

}
