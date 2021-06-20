package ar.edu.unju.fi.tpfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Controller
public class PaymentController {
	
	@Autowired
	private Payment payment;
	
	@Autowired
	@Qualifier("paymentServiceMysql")
	private IPaymentService paymentService;
	
	@Autowired
	@Qualifier("customerServiceImpMysql")
	private ICustomerService customerService;
	
	@GetMapping("/pago")
	public ModelAndView getPaymentPage() {
		ModelAndView model = new ModelAndView("payment");
		model.addObject("payments", paymentService.getPayments());
		return model;
		
//		model = new ModelAndView("compras");
//		Optional<Producto> producto = productoService.getProductoPorId(compra.getProducto().getId());
//		compra.setProducto(producto.get());
//		compra.setTotal(compra.getCantidad()*producto.get().getPrecio());
//		compraService.guardarCompra(compra);
//		model.addObject("compras", compraService.getCompras());
//		return model;
	}
	
	@GetMapping("/pago-nuevo")
	public String getPaymentPage(Model model) {
		model.addAttribute("pago",payment);
		model.addAttribute("clientes",customerService.getCustomers());
		return "newpayment";
	}
	
	@PostMapping("/pago-guardar") //No funciona
	public ModelAndView guardarClientePage(@ModelAttribute("payment")Payment payment) {
			ModelAndView model = new ModelAndView("payment");
//			paymentService.guardarPayment(payment);
//			model.addObject("payments", paymentService.getPayments());
			return model;
		
	}
	
	
}
