package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@SpringBootTest
class OfficeTest {

	@Autowired
	IOfficeService officeService;
	
	@Autowired
	IEmployeeService employeeService;
	
	@Test
	void testGuardarOffice() {
		List<Employee> empleados = new ArrayList<Employee>();
		Optional<Employee> empleadoEncontrado = employeeService.getEmployeePorId(1002);
		empleados.add(empleadoEncontrado.get());
		Office office = new Office("1", "San Francisco", "+16502194782", "100 MArket Stret", "Suite 300", "CA", "USA", "94080", "NA", empleados);
		officeService.guardarOffice(office);
		assertEquals("1", office.getId());
	}

}
