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

import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	private Product product;
	
	@Autowired
	@Qualifier("productServiceImpMysql")
	private IProductService productService;
	
	@Autowired
	@Qualifier("productLineServiceMysql")
	private IProductLineService productLineService;
	
	@GetMapping("/producto-nuevo")
	public String getProductoNuevo(Model model) {
		model.addAttribute("product", product);
		model.addAttribute("products",productService.getProductos());
		model.addAttribute("productlines", productLineService.getProductLines());
		return "newproduct";
	}
	
	@PostMapping("/producto-guardar")
	public ModelAndView guardarProductoPage(@Valid @ModelAttribute("product")Product product, BindingResult resultado) {
		ModelAndView model;
		if(resultado.hasErrors()) {
			model = new ModelAndView("newproduct");
			System.out.println(resultado);
			model.addObject("product", product);
			model.addObject("products",productService.getProductos());
			model.addObject("productlines", productLineService.getProductLines());
			return model;
		}
		else {
			model = new ModelAndView("productlist");
			Optional<ProductLine> encontrado = productLineService.getProducLinePorId(product.getProductLine().getId());
			System.out.println(encontrado);
			product.setProductLine(encontrado.get());
			productService.guardarProduct(product);
			model.addObject("products", productService.getProductos());
			return model;
		}
	}
	
	@GetMapping("/productos")
	public ModelAndView getProductosListadoPage() {
		ModelAndView model = new ModelAndView("productlist");
		//System.out.println(product.getProductScale());
		model.addObject("product", product);
		model.addObject("products", productService.getProductos());
		return model;
	}
	
	@GetMapping("/producto-editar-{id}")
	public ModelAndView getEditarProductoPage(@PathVariable(value="id")String id) {
		ModelAndView model = new ModelAndView("newproduct");
		Optional<Product> product = productService.getProductPorId(id);
		model.addObject("product", product);
		model.addObject("productlines", productLineService.getProductLines());
		return model;
	}
	
	@GetMapping("/producto-eliminar-{id}")
	public ModelAndView getEliminarProductoPage(@PathVariable(value="id")String id) {
		ModelAndView model = new ModelAndView("redirect:/productos");
		productService.eliminarProduct(id);
		return model;
	}
}
