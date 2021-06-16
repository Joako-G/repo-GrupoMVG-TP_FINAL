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
		Employee employee = new Employee(Integer.valueOf(1234), "Thompson", "Leslie", "x391", "lesthompson@gmail.com", "President", null, null, null, null);
		employeeService.guardarEmployee(employee);
		assertEquals("Thompson",employee.getApellido());
	}

}
