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

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOrderService;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Controller
public class CustomerController {
	
	@Autowired
	private Customer customer;
	
	@Autowired
	@Qualifier("customerServiceImpMysql")
	private ICustomerService customerService;
	
	@Autowired
	@Qualifier("employeeServiceMysql")
	private IEmployeeService employeeService;
	
	@Autowired
	@Qualifier("paymentServiceMysql")
	private IPaymentService paymentService;
	
	@Autowired
	@Qualifier("orderServiceMysql")
	private IOrderService orderService;
	
	
	@GetMapping("/cliente-nuevo")
	public String getNewCustomer(Model model){
		model.addAttribute("customer", customer);
		model.addAttribute("employees", employeeService.getEmployees());
		return "newcustomer";
	}
	
	@GetMapping("/errors")
	public String getErrorCustomer(){
		return "errors";
	}
	
	@PostMapping("/cliente-guardar")
	public ModelAndView guardarClientePage(@Valid @ModelAttribute("customer") Customer customer, BindingResult resultado) {
		ModelAndView model;
		if(resultado.hasErrors()) {
			model = new ModelAndView("newcustomer");
			model.addObject("customer", customer);
			model.addObject("employees", employeeService.getEmployees());
			return model;
		}
		else {
			model = new ModelAndView("customerlist");
			Optional<Employee> employee = employeeService.getEmployeePorId(customer.getEmpleado().getId());
			customer.setEmpleado(employee.get());
			customerService.guardarCustomer(customer);
			model.addObject("customers", customerService.getCustomers());
			//System.out.println(customer);
			return model;
		}
	}
	
	@GetMapping("/clientes")
	public ModelAndView getClienteListadoPage() {
		ModelAndView model = new ModelAndView("customerlist");
		model.addObject("customer", customer);
		model.addObject("customers", customerService.getCustomers());
		return model;
	}
	
	//ARREGLADO EL PROBLEMA DE LA DUPLICACION
	
	@GetMapping("/cliente-editar-{idCliente}")
	public ModelAndView getEditarClientePage(@PathVariable(value="idCliente") Long idCliente) {
		ModelAndView model = new ModelAndView("newcustomer");
		Optional<Customer> customer = customerService.getCustomerPorId(idCliente);
		model.addObject("customer", customer);
		//model.addObject("customers", customerService.getCustomers());
		model.addObject("employees", employeeService.getEmployees());
		return model;
	}
	
	@GetMapping("/cliente-eliminar-{idCliente}")
		public ModelAndView getEliminarClientePage(@PathVariable(name="idCliente")Long idCliente) {
			if (orderService.existOrderByCustomer(idCliente) == false) {
				if (paymentService.existPaymentByCustomer(idCliente) == false) {
					ModelAndView model = new ModelAndView("redirect:/clientes");
					customerService.elimarCustomer(idCliente);
					return model;
				}else {
					ModelAndView model = new ModelAndView("redirect:/errors");
					return model;	}
			}else {
				ModelAndView model = new ModelAndView("redirect:/errors");
				return model;
			}
		}
}
