package ar.edu.unju.fi.tpfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {

	@GetMapping("/index")
	public String getHomePage() {
		return "index";
	}
	
	@GetMapping("/about")
	public String getSobreNosotrosPage() {
		return "about";
	}
	
	@GetMapping("/galeria")
	public String getGaleriaPage() {
		return "portfolio";
	}
	
	@GetMapping("/equipo")
	public String getTeamPage() {
		return "team";
	}
	
	@GetMapping("/contacto")
	public String getContactPage() {
		return "contact";
	}
}
