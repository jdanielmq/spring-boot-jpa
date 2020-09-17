package cl.springboot.jpa.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.springboot.jpa.app.models.dao.IClienteDao;
import cl.springboot.jpa.app.models.entity.Cliente;

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
	
	@RequestMapping("/form")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "Formulario de Cliente");
		model.put("cliente", new Cliente());
		return "form";
	}
	
	@RequestMapping(value = "/form", method=RequestMethod.POST)
	public String guardar(@Validated Cliente cliente, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}
		
		
		IClienteDao.save(cliente);
		return "redirect:listado-cliente";
	}
	
	
	
	
	
}
