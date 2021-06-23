package ar.edu.unju.fi.tpfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailsId;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;

@Controller
public class OrderDetailController {

	@Autowired
	private OrderDetail orderDetail;
	
	@Autowired
	private OrderDetailsId orderDetailsId;
	
	@Autowired
	@Qualifier("orderDetailServiceMysql")
	private IOrderDetailService orderDetailService;
	
	@GetMapping("/detalle") //
	public ModelAndView getOrderDetailPage() { 
		ModelAndView model = new ModelAndView("orderdetail");
		model.addObject("orderDetails", orderDetailService.getOrderDetails());
		return model;
	}
	
}
