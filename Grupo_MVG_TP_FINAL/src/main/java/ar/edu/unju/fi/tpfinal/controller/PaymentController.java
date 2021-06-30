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
	
	@GetMapping("/pagos")
	public ModelAndView getPaymentPage() { 
		ModelAndView model = new ModelAndView("paymentlist");
		model.addObject("payments", paymentService.getPayments());
		return model;
	}
	
	@GetMapping("/pago-nuevo") 
	public String getPaymentPage(Model model) {
		model.addAttribute("pago",payment);
		model.addAttribute("clientes",customerService.getCustomers());
		return "newpayment";
	}
	
	@GetMapping("/pago-borrado") 
	public String getPaymentDeletedPage(Model model) {
		model.addAttribute("pid",paymentid);
		return "paymentdeleted";
	}

	
	@PostMapping("/pago-guardar") //No funcionan las validaciones(carteles)
	public ModelAndView guardarPaymentPage(@Valid @ModelAttribute("payment")Payment payment,BindingResult resultado) {
		ModelAndView model;
		if(resultado.hasErrors()) {
			model = new ModelAndView("newpayment");
			model.addObject("pago",payment);
			model.addObject("clientes",customerService.getCustomers());
			return model;
		}
		else {
			model = new ModelAndView("paymentlist");
			paymentService.guardarPayment(payment);
			model.addObject("payments", paymentService.getPayments());
			return model;
		}
	}
	
	@GetMapping("/pago-editar-{id}-{id2}")
	public ModelAndView modificarPaymentPage(@PathVariable (value = "id")Long idCliente, @PathVariable (value = "id2")String idCheque) {
		ModelAndView model = new ModelAndView("newpayment");
		//Seteo un orderDetailId con los id traidos desde el template
		Optional<Customer> cliente = customerService.getCustomerPorId(idCliente);
		paymentid.setCustomer(cliente.get());
		paymentid.setNumeroCheque(idCheque);
		//busco el orderDetail por el orderDetailId
		Optional<Payment> payment = paymentService.getPaymentPorId(paymentid);
		paymentService.eliminarPayment(paymentid);//LINEA AGREGADA PARA CAMBIAR ID Y QUE NO SE DUPLIQUE 
		model.addObject("pago",payment);
		model.addObject("clientes",customerService.getCustomers());
		return model;
	}
	
	@GetMapping("/pago-eliminar-{id}-{id2}")
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
