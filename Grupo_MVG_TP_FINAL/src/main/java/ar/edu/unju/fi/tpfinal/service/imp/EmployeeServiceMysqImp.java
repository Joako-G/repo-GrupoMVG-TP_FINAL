package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.repository.IEmployeeRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

@Service("employeeServiceMysql")
public class EmployeeServiceMysqImp implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	public void guardarEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	@Override
	public Optional<Employee> getEmployeePorId(Integer id) {
		Optional<Employee> empleado = employeeRepository.findById(id);
		return empleado;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		return employees;
	}

}
