package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Account;
import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.service.IAccountService;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@SpringBootTest
class AccountTest {
	
	@Autowired
	IAccountService cuentaService;
	
	@Autowired
	IEmployeeService employeeService;
	
	@Autowired
	IOfficeService officeService;

	@Test
	void testGuardarUsuario() {
		Account cuentaNueva = new Account();
		cuentaNueva.setPassword("administrador");
		cuentaNueva.setNombreUsuario("administrador");
		cuentaNueva.setRol("ADMINISTRADOR");
		
		cuentaService.guardarUsuario(cuentaNueva);
		
		Optional<Office> oficina1 = officeService.getOfficePorId("1");
		Employee empleadoNuevo = new Employee(Integer.valueOf(6), "Thompson", "Leslie", "x4065", "lthompson@classicmodelcars.com", "Sales Rep", oficina1.get(), null, cuentaNueva);
		
		employeeService.guardarEmployee(empleadoNuevo);
		
		assertEquals("ADMINISTRADOR",cuentaNueva.getRol());
	}

}
