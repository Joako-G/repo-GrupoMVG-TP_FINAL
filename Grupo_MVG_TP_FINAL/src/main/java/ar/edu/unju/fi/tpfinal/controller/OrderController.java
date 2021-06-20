package ar.edu.unju.fi.tpfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/orden")
	public ModelAndView getOrderPage() {
		ModelAndView model = new ModelAndView("order");
		model.addObject("orders", orderService.getOrders());
		return model;
	}
	
	@GetMapping("/orden-nueva")
	public String getOrderPage(Model model) {
		model.addAttribute("orden",order);
		model.addAttribute("clientes",customerService.getCustomers());
		return "neworder";
	}
}
