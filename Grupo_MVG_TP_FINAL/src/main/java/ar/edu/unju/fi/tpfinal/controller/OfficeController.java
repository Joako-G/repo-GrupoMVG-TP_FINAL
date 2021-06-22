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

import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@Controller
public class OfficeController {

	@Autowired
	private Office office;
	
	@Autowired
	@Qualifier("officeServiceMysql")
	private IOfficeService officeService;
	
	@GetMapping("/nueva-oficina")
	public String getOficinaNuevaPage(Model model) {
		model.addAttribute("office", office);
		return "office";
	}
	
	@PostMapping("/guardar-oficina")
	public ModelAndView guardarOficinaPage(@Valid @ModelAttribute("office")Office office, BindingResult resultadoValidacion) {
		ModelAndView model;
		if(resultadoValidacion.hasErrors()) {
			model = new ModelAndView("office");
			return model;
		}
		else {
			model = new ModelAndView("officelist");
			officeService.guardarOffice(office);
			model.addObject("offices", officeService.getOffices());
			return model;
		}
	}
	
	@GetMapping("/oficinas")
	public String listarOficinasPage(Model model) {
		model.addAttribute("offices", officeService.getOffices());
		return "officelist";
	}
	
	@GetMapping("/editar-oficina-{id}")
	public ModelAndView modificarOficinaPage(@PathVariable(value = "id")String id) {
		ModelAndView model = new ModelAndView("office");
		Optional<Office> oficinaEncontrada = officeService.getOfficePorId(id);
		model.addObject("office", oficinaEncontrada);
		return model;
	}
	
	@GetMapping("/eliminar-oficina/{id}")
	public ModelAndView eliminarOficinaPage(@PathVariable(value = "id")String id) {
		ModelAndView model = new ModelAndView("redirect:/oficinas");
		officeService.eliminarOffice(id);
		return model;
	}
}
