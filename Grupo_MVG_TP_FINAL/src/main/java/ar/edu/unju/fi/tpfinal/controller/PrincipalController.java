package ar.edu.unju.fi.tpfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {

	@GetMapping("/index")
	public String getHomePage() {
		return "index";
	}
}
