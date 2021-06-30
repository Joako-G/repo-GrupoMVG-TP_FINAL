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
import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailsId;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@Controller
public class OrderController {

	@Autowired
	private Order order;
	
	@Autowired
	private OrderDetail orderDetail;
	
	@Autowired
	private OrderDetailsId orderDetailsId;
	
	@Autowired
	@Qualifier("orderServiceMysql")
	private IOrderService orderService;
	
	@Autowired
	@Qualifier("customerServiceImpMysql")
	private ICustomerService customerService;
	
	@Autowired
	@Qualifier("orderDetailServiceMysql")
	private IOrderDetailService orderDetailService;
	
	
	@GetMapping("/ordenes") 
	public ModelAndView getOrderPage() {
		ModelAndView model = new ModelAndView("orderlist");
		model.addObject("orders", orderService.getOrders());
		return model;
	}
	
	@GetMapping("/orden-borrada")
	public ModelAndView getOrderDeletedPage() {
		ModelAndView model = new ModelAndView("orderdeleted");
		return model;
	}
	
	@GetMapping("/orden-nueva") 
	public String getOrderNuevaPage(Model model) {
		model.addAttribute("orden",order);
		model.addAttribute("clientes",customerService.getCustomers());
		return "neworder";
	}
	
	@PostMapping("orden-guardar") //Funciona OK. Con validaciones
	public ModelAndView guardarOrderPage(@Valid @ModelAttribute("orden")Order order, BindingResult validacion) {
		ModelAndView model;
		System.out.println(order);
		if(validacion.hasErrors()) {
			System.out.println("validacion: " + validacion.hasErrors());
			model = new ModelAndView("neworder");
			model.addObject("orden",order);
			model.addObject("clientes",customerService.getCustomers());
			return model;
		}
		else {
			model = new ModelAndView("orderlist");
			orderService.guardarOrder(order);
			model.addObject("orders", orderService.getOrders());
			return model;
		}
	}
	
	@GetMapping("/orden-editar-{id}")
	public ModelAndView modificarOrderPage(@PathVariable (value = "id")int id) {
		ModelAndView model = new ModelAndView("neworder");
		Optional<Order> order = orderService.getOrderPorId(id);
		model.addObject("orden",order);
		model.addObject("clientes",customerService.getCustomers());
		return model;
	}
	
	@GetMapping("/orden-eliminar-{id}")
	public ModelAndView eliminarOrderPage(@PathVariable(value = "id") int id) {
		ModelAndView model = new ModelAndView("redirect:/orden-borrada");		
		orderDetailService.eliminarOrderDetailByOrderId(id);
		orderService.eliminarOrder(id);
		return model;
	}
}
