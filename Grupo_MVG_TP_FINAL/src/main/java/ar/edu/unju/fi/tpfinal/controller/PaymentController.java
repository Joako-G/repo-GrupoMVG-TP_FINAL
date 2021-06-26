package ar.edu.unju.fi.tpfinal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView guardarPaymentPage(@ModelAttribute("payment")Payment payment) {
			ModelAndView model = new ModelAndView("payment");
			System.out.println(payment);
			paymentService.guardarPayment(payment);
			model.addObject("payments", paymentService.getPayments());
			
			return model;
		
	}
	
	@GetMapping("/pago-editar-{id}-{id2}") //No funciona. Problemas con el id oculto del template newpayment
	public ModelAndView modificarPaymentPage(@PathVariable (value = "id")Long idCliente, @PathVariable (value = "id2")String idCheque) {
		ModelAndView model = new ModelAndView("newpayment");
		paymentid.customer.setIdCliente(idCliente);
		paymentid.setNumeroCheque(idCheque);
		Optional<Payment> payment = paymentService.getPaymentPorId(paymentid);
		System.out.println("id cliente: " + paymentid.customer.getIdCliente());
		System.out.println("id cheque: " +paymentid.getNumeroCheque());
		model.addObject("pago",payment.get());
		model.addObject("clientes",customerService.getCustomers());
		return model;
	}
	
	@GetMapping("/pago-eliminar-{id}-{id2}") //Funciona OK
	public ModelAndView eliminarPaymentPage(@PathVariable (value = "id")Long idCliente, @PathVariable (value = "id2")String idCheque) {
		ModelAndView model = new ModelAndView("redirect:/pago-borrado");
		paymentid.customer.setIdCliente(idCliente);
		paymentid.setNumeroCheque(idCheque);
		paymentService.eliminarPayment(paymentid);
		model.addObject("pid",paymentid);
		return model;
	}
	
	
}
