package ar.edu.unju.fi.tpfinal.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	//public ModelAndView guardarProductLinePage(@Valid @ModelAttribute("productline")ProductLine productLine, BindingResult resultado) {
	public ModelAndView guardarProductLinePage(@Valid @ModelAttribute("productline")ProductLine productLine , @RequestParam(name="file", required = false) MultipartFile imagen, BindingResult resultado) {
		ModelAndView model;
		
		if(resultado.hasErrors()) {
			model = new ModelAndView("productline");
			return model;
		}
		else {
				model = new ModelAndView("productlinelist");
				/*String ruta = "D://Temp//uploads";
				try {
					byte[] bytes = imagen.getBytes();
					Path rutaAbsoluta = Paths.get(ruta + "//" + imagen.getOriginalFilename());
					Files.write(rutaAbsoluta, bytes);
				}catch (Exception e) {
					// TODO: handle exception
				}*/
				
				//Path directorio = Paths.get("src//main//resources//static/image");
				//String ruta = "D://Joaquin//uploads";
				String ruta = "E://Documentos//Flor";
				try {
					byte[] byteImg = imagen.getBytes();
					Path rutaCompleta = Paths.get(ruta + "//" + imagen.getOriginalFilename());
					Files.write(rutaCompleta, byteImg);
					productLine.setImagen(imagen.getOriginalFilename());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
