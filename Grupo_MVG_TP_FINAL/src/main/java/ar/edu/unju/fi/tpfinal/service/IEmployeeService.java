package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Employee;

public interface IEmployeeService {
	
	void guardarEmployee(Employee employee);
	public Optional<Employee> getEmployeePorId(Integer id);
	public boolean existEmpleadoPorEmpleado(Integer employeeId);
	public List<Employee> getEmployees();
	void eliminarEmployee(Integer id);

}
