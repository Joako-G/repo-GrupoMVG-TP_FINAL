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
import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;
import ar.edu.unju.fi.tpfinal.service.IOrderService;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Controller
public class OrderDetailController {

	@Autowired
	private OrderDetail orderDetail;
	
	@Autowired
	private OrderDetailsId orderDetailsId;
	
	@Autowired
	@Qualifier("orderDetailServiceMysql")
	private IOrderDetailService orderDetailService;
	
	@Autowired
	@Qualifier("productServiceImpMysql")
	private IProductService productService;
	
	@Autowired
	@Qualifier("orderServiceMysql")
	private IOrderService orderService;
	
	@GetMapping("/detalle") //Funciona OK
	public ModelAndView getOrderDetailPage() { 
		ModelAndView model = new ModelAndView("orderdetail");
		model.addObject("orderDetails", orderDetailService.getOrderDetails());
		return model;
	}
	
	@GetMapping("/detalle-nuevo")
	public String getOrderDetailNewPage(Model model) {
		model.addAttribute("detalle",orderDetail);
		model.addAttribute("ordenes", orderService.getOrders());
		model.addAttribute("productos", productService.getProductos());
		return "neworderdetail";
	}
	
	@GetMapping("/detalle-borrado") 
	public String getOrderDetailDeletedPage(Model model) {
		model.addAttribute("oid",orderDetailsId);
		return "orderdetaildeleted";
	}
	
	//NO FUNCIONAN LAS VALIDACIONES (NO APARECEN LOS CARTELES)
	
	@PostMapping("/detalle-guardar") 
	public ModelAndView guardarOrderDetailPage(@Valid @ModelAttribute("detalle")OrderDetail detalle, BindingResult resultado) {
		ModelAndView model;
		if(resultado.hasErrors()) {
			model = new ModelAndView("neworderdetail");
			model.addObject("detalle",orderDetail);
			model.addObject("ordenes", orderService.getOrders());
			model.addObject("productos", productService.getProductos());
			return model;
		}
		else {
			model = new ModelAndView("orderdetail");
			System.out.println(detalle);
			orderDetailService.guardarOrderDetail(detalle);
			model.addObject("orderDetails", orderDetailService.getOrderDetails());	
			return model;
		}
	}
	
	@GetMapping("/detalle-eliminar-{id}-{id2}")
	public ModelAndView eliminarOrderDetailPage(@PathVariable (value = "id")int orderId, @PathVariable (value = "id2")String productId) {
		ModelAndView model = new ModelAndView("redirect:/detalle-borrado");
		
		Optional<Order> order = orderService.getOrderPorId(orderId);
		orderDetailsId.setOrder(order.get());
		Optional<Product> product = productService.getProductPorId(productId);
		orderDetailsId.setProduct(product.get());
		orderDetailService.eliminarOrderDetail(orderDetailsId);
		model.addObject("oid",orderDetailsId);
		return model;
	}
	
	@GetMapping("/detalle-editar-{id}-{id2}") 
	public ModelAndView modificarOrderDetailPage(@PathVariable (value = "id")int orderId, @PathVariable (value = "id2")String productId) {
		ModelAndView model = new ModelAndView("neworderdetail");
		//Seteo un orderDetailId con los id traidos desde el template
		Optional<Order> order = orderService.getOrderPorId(orderId);
		orderDetailsId.setOrder(order.get());
		Optional<Product> product = productService.getProductPorId(productId);
		orderDetailsId.setProduct(product.get());
		
		//busco el orderDetail por el orderDetailId
		Optional<OrderDetail> orderDetail = orderDetailService.getOrderDetailPorId(orderDetailsId);
		
		model.addObject("detalle",orderDetail);
		model.addObject("ordenes", orderService.getOrders());
		model.addObject("productos", productService.getProductos());
		return model;

	}
}
