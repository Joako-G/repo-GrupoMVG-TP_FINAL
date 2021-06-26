package ar.edu.unju.fi.tpfinal.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.Employee;
//import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@Controller
public class EmployeeController {

	@Autowired
	private Employee employee;
	
	@Autowired
	@Qualifier("employeeServiceMysql")
	private IEmployeeService employeeService;
	
	@Autowired
	@Qualifier("officeServiceMysql")
	private IOfficeService officeService;
	
	@GetMapping("/nuevo-empleado")
	public String getEmpleadoNuevoPage(Model model) {
		model.addAttribute("employee", employee);
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("offices", officeService.getOffices());
		return "newemployee";
	}
	
	@PostMapping("/guardar-empleado")
	public ModelAndView guardarEmpleadoPage(@Valid @ModelAttribute ("employee")Employee employee, BindingResult resultadoValidacion) {
		ModelAndView model;
		if(resultadoValidacion.hasErrors()) {
			model = new ModelAndView("newemployee");
			model.addObject("employees", employeeService.getEmployees());
			model.addObject("offices", officeService.getOffices());
			return model;
		}
		else {
			model = new ModelAndView("employeelist");
			Optional<Employee> empleadoEncontrado = employeeService.getEmployeePorId(employee.getSuperior().getId());
			//Optional<Office> oficinaEncontrada = officeService.getOfficePorId(employee.getOficina().getId());
			employee.setSuperior(empleadoEncontrado.get());
			//employee.setOficina(oficinaEncontrada.get());
			employeeService.guardarEmployee(employee);
			model.addObject("employees", employeeService.getEmployees());
			return model;
		}
	}
	
	@GetMapping("/empleados")
	public String listarEmpleadosPage(Model model) {
		model.addAttribute("employees", employeeService.getEmployees());
		return "employeelist";
	}
	
	@GetMapping("/editar-empleado-{id}")
	public ModelAndView modificarEmpleadoPage(@PathVariable (value = "id")Integer id) {
		ModelAndView model = new ModelAndView("newemployee");
		Optional<Employee> empleadoEncontrado = employeeService.getEmployeePorId(id);
		model.addObject("employee", empleadoEncontrado);
		model.addObject("employees", employeeService.getEmployees());
		model.addObject("offices", officeService.getOffices());
		return model;
	}
	
	@GetMapping("/eliminar-empleado/{id}")
	public ModelAndView eliminarEmpleadoPage(@PathVariable(value = "id")Integer id) {
		ModelAndView model = new ModelAndView("redirect:/empleados");
		employeeService.eliminarEmployee(id);
		return model;
	}
}
