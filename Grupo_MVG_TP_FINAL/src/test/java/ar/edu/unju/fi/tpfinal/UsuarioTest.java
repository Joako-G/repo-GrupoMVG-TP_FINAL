package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@SpringBootTest
class UsuarioTest {

	@Autowired
	IEmployeeService employeeService;
	
	@Autowired
	IOfficeService officeService;
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Test
	void testGuardarUsuario() {
		
		Optional<Office> oficina = officeService.getOfficePorId("1");
		
		Usuario usuarioNuevo = new Usuario(Long.valueOf(1),"administrador",encoder.encode("administrador"),"ADMIN");
		Employee empleadoNuevo = new Employee(Integer.valueOf(1406), "Vanauf", "George", "x2759", "gvanauf@classicmodelcars.com", "Sales Rep", oficina.get(), null, usuarioNuevo);
		employeeService.guardarEmployee(empleadoNuevo);
		
		
		Usuario usuarioNuevo2 = new Usuario(Long.valueOf(2),"editor",encoder.encode("admin"),"ADMIN");
		Employee empleadoNuevo2 = new Employee(Integer.valueOf(1407), "Castillo", "Pamela", "x2759", "pcastillo@classicmodelcars.com", "Sales Rep", oficina.get(), null, usuarioNuevo2);
		employeeService.guardarEmployee(empleadoNuevo2);
		
		
		
		Usuario usuarioNuevo3 = new Usuario(Long.valueOf(3),"consultor",encoder.encode("admin"),"ADMIN");
		Employee empleadoNuevo3 = new Employee(Integer.valueOf(1408), "Bondur", "Loui", "x2759", "lbondur@classicmodelcars.com", "Sales Rep", oficina.get(), null, usuarioNuevo3);
		employeeService.guardarEmployee(empleadoNuevo3);
		
		
		
		Usuario usuarioNuevo4 = new Usuario(Long.valueOf(4),"carine",encoder.encode("carine"),"CONSULTOR");
		Optional<Employee> empleado = employeeService.getEmployeePorId(2);
		assertEquals(2,empleado.get().getId());
		
		Customer cliente = new Customer(Long.valueOf(1), "Atelier graphique","Schmitt", "Carine ", "40.32.2555", "54, rue Royale", null, "Nantes", null, "4400", "France", BigDecimal.valueOf(1370), empleado.get(),usuarioNuevo4);
		customerService.guardarCustomer(cliente);
		
		
		assertEquals("CONSULTOR",cliente.getUsuario().getRol());
		
		assertEquals("administrador", usuarioNuevo.getNombreUsuario());
	}

}
