package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@SpringBootTest
class EmployeeTest {

	@Autowired
	IEmployeeService employeeService;
	
	@Autowired
	IOfficeService officeService;
	
	@Test
	void testGuardarEmployee() {
		Optional<Office> oficina1 = officeService.getOfficePorId("1");
		Optional<Office> oficina2 = officeService.getOfficePorId("5");
		Optional<Office> oficina3 = officeService.getOfficePorId("4");
		
		Employee employee1 = new Employee(Integer.valueOf(1), "Murphy", "Diane", "x5800", "dmurphy@classicmodelcars.com", "President", oficina1.get(), null, null);
		employeeService.guardarEmployee(employee1);
		
		System.out.println(employee1);
		System.out.println(employee1.getOficina());
		System.out.println(employee1.getSuperior());
		
		Optional<Employee> superior1 = employeeService.getEmployeePorId(1);
		
		Employee employee2 = new Employee(Integer.valueOf(2), "Patterson", "Mary", "x4611", "mpatterso@classicmodelcars.com", "VP Sales", oficina1.get(),superior1.get(), null);
		employeeService.guardarEmployee(employee2);
		
		System.out.println("Superior: " + employee2.getSuperior().getId());
		
		Employee employee3 = new Employee(Integer.valueOf(3), "Firrelli", "Jeff", "x9273", "jfirrelli@classicmodelcars.com", "VP Marketing", oficina1.get(), superior1.get(), null);
		employeeService.guardarEmployee(employee3);
		
		Employee employee4 = new Employee(Integer.valueOf(4), "Patterson", "William", "x4871", "wpatterson@classicmodelcars.com", "Sales Manager (APAC)", oficina2.get(), employee2, null);
		employeeService.guardarEmployee(employee4);
		
		Employee employee5 = new Employee(Integer.valueOf(5), "Bondur", "Gerard", "x5408", "gbondur@classicmodelcars.com", "Sale Manager (EMEA)", oficina3.get(), employee2, null);
		employeeService.guardarEmployee(employee5);
		
		assertEquals("Murphy",employee1.getApellido());
		assertEquals("1",oficina1.get().getId());
		assertEquals("5",oficina2.get().getId());
		assertEquals("4",oficina3.get().getId());
	}

}
