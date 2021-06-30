package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.repository.IEmployeeRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

@Service("employeeServiceMysql")
public class EmployeeServiceMysqImp implements IEmployeeService {
	
	private static final Log LOGGER = LogFactory.getLog(EmployeeServiceMysqImp.class);

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

	@Override
	public void eliminarEmployee(Integer id) {
		employeeRepository.deleteById(id);		
	}

	@Override
	public boolean existEmpleadoPorEmpleado(Integer employeeId) {
		LOGGER.info("METHOD: existEmpleadoPorEmpleado ---- Se consultó si un empleado existe como superior en la tabla de empleados. Id del empleado: " + employeeId);
		boolean band = false;
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		for (int i=1;i<employees.size();i++) {
			Employee elementoLista = employees.get(i);
			if (elementoLista.getSuperior().getId().compareTo(employeeId)==0) {
				band = true;
			}		
		}
		return band;
	}

}
