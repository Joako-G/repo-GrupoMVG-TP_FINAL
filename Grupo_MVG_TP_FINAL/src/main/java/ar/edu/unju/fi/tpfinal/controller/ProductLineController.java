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

import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;

@Controller
public class ProductLineController {
	
	@Autowired
	private ProductLine productLine;
	
	@Autowired
	@Qualifier("productLineServiceMysql")
	private IProductLineService productLineService;
	
	@GetMapping("/productline-nuevo")
	public String getNewProductLine(Model model) {
		model.addAttribute("productline", productLine);
		return "productline";
	}
	
	@PostMapping("/productline-guardar")
	public ModelAndView guardarProductLinePage(@Valid @ModelAttribute("productline")ProductLine productLine, BindingResult resultado) {
		ModelAndView model;
		
		if(resultado.hasErrors()) {
			model = new ModelAndView("productline");
			return model;
		}
		else {
				model = new ModelAndView("productlinelist");
				productLineService.guardarProductLine(productLine);
				model.addObject("productlinelist", productLineService.getProductLines());
				return model;
		}
	}
	
	@GetMapping("/productline-listado")
	public ModelAndView getListadoPage() {
		ModelAndView model = new ModelAndView("productlinelist");
		model.addObject("productlinelist", productLineService.getProductLines());
		return model;
	}
	
	@GetMapping("/productline-editar-{id}")
	public ModelAndView getEditarProductLinePage(@PathVariable(value="id")String id) {
		ModelAndView model = new ModelAndView("productline");
		Optional<ProductLine> prodcutLine = productLineService.getProducLinePorId(id);
		model.addObject("productline", prodcutLine);
		return model;
	}
	
	@GetMapping("/productline/eliminar/{id}")
	public ModelAndView getProductLineEliminar(@PathVariable(value="id")String id) {
		ModelAndView model = new ModelAndView("redirect:/productline-listado");
		productLineService.eliminarProductLine(id);
		return model;
	}
}
