package ar.edu.unju.fi.tpfinal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;

@Controller
public class ProductLineController {
	
	@Autowired
	private ProductLine productLine;
	
	@Autowired
	private IProductLineService productLineService;
	
	@GetMapping("/productline/nuevo")
	public String getNewProductLine(Model model) {
		model.addAttribute("productline", productLine);
		return "productline";
	}
	
	@PostMapping("/productline/guardar")
	public ModelAndView guardarProductLinePage(@Valid @ModelAttribute("productline")ProductLine productLine, BindingResult resultado) {
		ModelAndView model;
		if(resultado.hasErrors()) {
			model = new ModelAndView("productline");
			return model;
		}
		else {
			model = new ModelAndView("productlinelist");
			productLineService.guardarProductLine(productLine);
			return model;
		}
	}
}
