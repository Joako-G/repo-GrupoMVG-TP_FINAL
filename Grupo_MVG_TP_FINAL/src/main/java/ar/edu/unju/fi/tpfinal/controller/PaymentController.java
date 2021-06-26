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
import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Controller
public class PaymentController {
	
	@Autowired
	private Payment payment;
	
	@Autowired
	private PaymentId paymentid;
	
	@Autowired
	@Qualifier("paymentServiceMysql")
	private IPaymentService paymentService;
	
	@Autowired
	@Qualifier("customerServiceImpMysql")
	private ICustomerService customerService;
	
	@GetMapping("/pago") //Funciona OK
	public ModelAndView getPaymentPage() { 
		ModelAndView model = new ModelAndView("payment");
		model.addObject("payments", paymentService.getPayments());
		return model;
	}
	
	@GetMapping("/pago-nuevo") //Funciona OK
	public String getPaymentPage(Model model) {
		model.addAttribute("pago",payment);
		model.addAttribute("clientes",customerService.getCustomers());
		return "newpayment";
	}
	
	@GetMapping("/pago-borrado") //Funciona OK
	public String getPaymentDeletedPage(Model model) {
		model.addAttribute("pid",paymentid);
		return "paymentdeleted";
	}

	
	@PostMapping("/pago-guardar") //Funciona OK. Sin validaciones
	public ModelAndView guardarPaymentPage(@Valid @ModelAttribute("payment")Payment payment, BindingResult resultado) {
		ModelAndView model;
		if(resultado.hasErrors()) {
			model = new ModelAndView("newpayment");
			model.addObject("pago",payment);
			model.addObject("clientes",customerService.getCustomers());
			return model;
		}
		else {
			model = new ModelAndView("payment");
			paymentService.guardarPayment(payment);
			model.addObject("payments", paymentService.getPayments());
			return model;
		}
	}
	
	@GetMapping("/pago-editar-{id}-{id2}") //No funciona. Problemas con el id oculto del template newpayment
	public ModelAndView modificarOrderDetailPage(@PathVariable (value = "id")int orderId, @PathVariable (value = "id2")String productId) {
		ModelAndView model = new ModelAndView("neworderdetail");
		//Seteo un orderDetailId con los id traidos desde el template
		Optional<Order> order = orderService.getOrderPorId(orderId);
		orderDetailsId.setOrder(order.get());
		Optional<Product> product = productService.getProductPorId(productId);
		orderDetailsId.setProduct(product.get());
		
		//busco el orderDetail por el orderDetailId
		Optional<OrderDetail> orderDetail = orderDetailService.getOrderDetailPorId(orderDetailsId);
		orderDetailService.eliminarOrderDetail(orderDetailsId); //LINEA AGREGADA PARA CAMBIAR ID Y QUE NO SE DUPLIQUE
		model.addObject("detalle",orderDetail);
		model.addObject("ordenes", orderService.getOrders());
		model.addObject("productos", productService.getProductos());
		return model;

	}
	
	@GetMapping("/pago-eliminar-{id}-{id2}") //Funciona OK
	public ModelAndView eliminarPaymentPage(@PathVariable (value = "id")Long idCliente, @PathVariable (value = "id2")String idCheque) {
		ModelAndView model = new ModelAndView("redirect:/pago-borrado");
		
		Optional<Customer> cliente = customerService.getCustomerPorId(idCliente);
		paymentid.setCustomer(cliente.get());
		paymentid.setNumeroCheque(idCheque);
		payment.setId(paymentid);
		paymentService.eliminarPayment(paymentid);
		model.addObject("pid",paymentid);
		
		return model;
	}
	
	
}
