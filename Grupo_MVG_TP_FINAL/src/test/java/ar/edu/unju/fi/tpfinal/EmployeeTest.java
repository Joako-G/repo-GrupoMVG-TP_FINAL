package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Account;
import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.service.IAccountService;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@SpringBootTest
class EmployeeTest {

	@Autowired
	IEmployeeService employeeService;
	
	@Autowired
	IOfficeService officeService;
	
	@Autowired
	@Qualifier("customerServiceImpMysql")
	ICustomerService customerService;
	
	@Autowired
	IAccountService cuentaService;
	
	@Test
	void testGuardarEmployee() {

		Optional<Office> oficina1 = officeService.getOfficePorId("1");
		Optional<Office> oficina2 = officeService.getOfficePorId("5");
		Optional<Office> oficina3 = officeService.getOfficePorId("4");
		
		Employee employee1 = new Employee(Integer.valueOf(1), "Murphy", "Diane", "x5800", "dmurphy@classicmodelcars.com", "President", oficina1.get(), null, null);
		
		Account cuenta1 = new Account();
		cuenta1.setPassword("administrador");
		cuenta1.setNombreUsuario("administrador");
		cuenta1.setRol(employee1.getTitulo());
		cuentaService.guardarUsuario(cuenta1);
		
		employee1.setCuenta(cuenta1);
		employeeService.guardarEmployee(employee1);
		
		
		
		Optional<Employee> superior1 = employeeService.getEmployeePorId(1);
		
		Employee employee2 = new Employee(Integer.valueOf(2), "Patterson", "Mary", "x4611", "mpatterso@classicmodelcars.com", "VP Sales", oficina1.get(),superior1.get(), null);
		Account cuenta = new Account();
		cuenta.setPassword("Mary");
		cuenta.setNombreUsuario("Mary");
		cuenta.setRol(employee2.getTitulo());
		cuentaService.guardarUsuario(cuenta);
		
		employee2.setCuenta(cuenta);
		employeeService.guardarEmployee(employee2);
		
		
		
		Employee employee3 = new Employee(Integer.valueOf(3), "Firrelli", "Jeff", "x9273", "jfirrelli@classicmodelcars.com", "VP Marketing", oficina1.get(), superior1.get(), null);
		employeeService.guardarEmployee(employee3);
		
		Employee employee4 = new Employee(Integer.valueOf(4), "Patterson", "William", "x4871", "wpatterson@classicmodelcars.com", "Sales Manager (APAC)", oficina2.get(), employee2, null);
		
		Account cuenta2 = new Account();
		cuenta2.setPassword("William");
		cuenta2.setNombreUsuario("William");
		cuenta2.setRol(employee4.getTitulo());
		cuentaService.guardarUsuario(cuenta2);
		
		employee4.setCuenta(cuenta2);
		employeeService.guardarEmployee(employee4);
		
		
		
		Employee employee5 = new Employee(Integer.valueOf(5), "Bondur", "Gerard", "x5408", "gbondur@classicmodelcars.com", "Sales Rep", oficina3.get(), employee2, null);
		
		Account cuenta3 = new Account();
		cuenta3.setPassword("Gerard");
		cuenta3.setNombreUsuario("Gerard");
		cuenta3.setRol(employee5.getTitulo());
		cuentaService.guardarUsuario(cuenta3);
		
		employee5.setCuenta(cuenta3);
		employeeService.guardarEmployee(employee5);
		
		assertEquals("President",employee1.getTitulo());
	}

}
