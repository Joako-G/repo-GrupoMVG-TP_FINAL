package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

@SpringBootTest
class EmployeeTest {

	@Autowired
	IEmployeeService employeeService;
	@Test
	void testGuardarEmployee() {
		Employee employee1 = new Employee(Integer.valueOf(1), "Murphy", "Diane", "x5800", "dmurphy@classicmodelcars.com", "President", null, null, null, null);
		employeeService.guardarEmployee(employee1);
		
		Employee employee2 = new Employee(Integer.valueOf(2), "Jones", "Barry", "x102", "bjones@classicmodelcars.com", "Sales Rep", null, null, null, null);
		employeeService.guardarEmployee(employee2);
		
		Employee employee3 = new Employee(Integer.valueOf(3), "Bondur", "Gerard", "x5408", "gbondur@classicmodelcars.com", "Sale Manager (EMEA)", null, null, null, null);
		employeeService.guardarEmployee(employee3);
		
		assertEquals("Murphy",employee1.getApellido());
	}

}
