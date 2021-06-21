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

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@Controller
public class OrderController {

	@Autowired
	private Order order;
	
	@Autowired
	@Qualifier("orderServiceMysql")
	private IOrderService orderService;
	
	@Autowired
	@Qualifier("customerServiceImpMysql")
	private ICustomerService customerService;
	
	@GetMapping("/orden") //Funciona OK
	public ModelAndView getOrderPage() {
		ModelAndView model = new ModelAndView("order");
		model.addObject("orders", orderService.getOrders());
		return model;
	}
	
	@GetMapping("/orden-borrada") //Funciona OK
	public ModelAndView getOrderDeletedPage() {
		ModelAndView model = new ModelAndView("orderdeleted");
		return model;
	}
	
	@GetMapping("/orden-nueva") //Funciona OK
	public String getOrderNuevaPage(Model model) {
		model.addAttribute("orden",order);
		model.addAttribute("clientes",customerService.getCustomers());
		return "neworder";
	}
	
	@PostMapping("orden-guardar") //Funciona OK. Con validaciones
	public ModelAndView guardarOrderPage(@Valid @ModelAttribute("orden")Order order, BindingResult validacion) {
		ModelAndView model;
		if(validacion.hasErrors()) {
			model = new ModelAndView("neworder");
			model.addObject("orden",order);
			model.addObject("clientes",customerService.getCustomers());
			System.out.println(order);
			return model;
		}
		else {
			model = new ModelAndView("order");
			System.out.println(order);
			orderService.guardarOrder(order);
			model.addObject("orders", orderService.getOrders());
			System.out.println(order);
			return model;
		}
	}
	
	@GetMapping("/orden-editar-{id}") //No funciona!
	public ModelAndView modificarOrderPage(@PathVariable (value = "id")int id) {
		ModelAndView model = new ModelAndView("neworder");
		Optional<Order> order = orderService.getOrderPorId(id);
		model.addObject("orden",order);
		model.addObject("clientes",customerService.getCustomers());
		return model;
	}
	
	@GetMapping("/orden-eliminar-{id}") //Funciona OK
	public ModelAndView eliminarOrderPage(@PathVariable(value = "id") int id) {
		ModelAndView model = new ModelAndView("redirect:/orden-borrada");
		orderService.eliminarOrder(id);
		model.addObject(id);
		return model;
	}
}
