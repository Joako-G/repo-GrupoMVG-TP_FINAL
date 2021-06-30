package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;


@SpringBootTest
class CustomerTest {

		@Autowired
		@Qualifier("customerServiceImpMysql")
		private ICustomerService customerService;
		
		@Autowired
		IEmployeeService employeeService;
		
		@Test
		void testGuardarCustomer() {
			Optional<Employee> empleado1 = employeeService.getEmployeePorId(4);
			assertEquals(4,empleado1.get().getId());
			
			Optional<Employee> empleado2 = employeeService.getEmployeePorId(5);
			
			Customer cliente1 = new Customer(Long.valueOf(1), "Atelier graphique","Schmitt", "Carine ", "40.32.2555", "54, rue Royale", null, "Nantes", null, "4400", "France", BigDecimal.valueOf(1370), empleado1.get());
			customerService.guardarCustomer(cliente1);
			
			System.out.println(cliente1);
			
			Customer cliente2 = new Customer(Long.valueOf(2), "Signal Gift Stores","King", "Jean ", "7025551838", "8489 Strong St.", null, "Las Vegas", "NV", "83030", "USA", BigDecimal.valueOf(71800.00), empleado2.get());
			customerService.guardarCustomer(cliente2);
			
			Customer cliente3 = new Customer(Long.valueOf(3), "Australian Collectors, Co.","Ferguson", "Peter ", "03 9520 4555", "636 St Kilda Road", "Level 3", "Melbourne", "Melbourne", "3004", "Australia", BigDecimal.valueOf(117300.00), empleado2.get());
			customerService.guardarCustomer(cliente3);
			
			Customer cliente4 = new Customer(Long.valueOf(4), "La Rochelle Gifts","Labrune", "Janine  ", "40.67.8555", "67, rue des Cinquante Otages", null, "Nantes", null, "4400", "France", BigDecimal.valueOf(118200.00), empleado1.get());
			customerService.guardarCustomer(cliente4);
			
			Customer cliente5 = new Customer(Long.valueOf(5), "Baane Mini Imports","Bergulfsen", "Jonas  ", "07-98 9555", "Erling Skakkes gate 78", null, "Stavern", null, "4110", "Norway", BigDecimal.valueOf(81700.00), empleado1.get());
			customerService.guardarCustomer(cliente5);
			
			assertEquals(1,cliente1.getIdCliente());
		}

}