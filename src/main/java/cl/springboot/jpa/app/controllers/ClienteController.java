package cl.springboot.jpa.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.springboot.jpa.app.models.dao.IClienteDao;

@Controller
@RequestMapping("/app")
public class ClienteController {
	
	@Autowired
	IClienteDao IClienteDao;

	@GetMapping("/listado-cliente")
	public String getClientes(Model model){
		model.addAttribute("titulo", "Cliente de la  Empresa");
		model.addAttribute("listado", IClienteDao.findAll());
		return "index";
	}
}
