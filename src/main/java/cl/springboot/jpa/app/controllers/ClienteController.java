package cl.springboot.jpa.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cl.springboot.jpa.app.models.dao.IClienteDao;
import cl.springboot.jpa.app.models.entity.Cliente;
import cl.springboot.jpa.app.models.services.IClienteService;

@Controller
@RequestMapping("/app")
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	IClienteService IClienteService;

	@GetMapping("/listado-cliente")
	public String getClientes(Model model){
		model.addAttribute("titulo", "Cliente de la  Empresa");
		model.addAttribute("listado", IClienteService.findAll());
		return "index";
	}
	
	@RequestMapping("/form")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "Formulario de Cliente");
		model.put("cliente", new Cliente());
		return "form";
	}
	
	@RequestMapping(value = "/form", method=RequestMethod.POST)
	public String guardar(@Validated Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}
		IClienteService.save(cliente);
		status.setComplete();
		return "redirect:/app/listado-cliente";
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		IClienteService.deleteOne(IClienteService.findOne(id));
		return "redirect:/app/listado-cliente";
	}
	
	
	@RequestMapping("/form/{id}")
	public String editar(@PathVariable(value = "id") Long id,   Map<String, Object> model) {
		
		Cliente cliente = null;
		if(id > 0)
		    cliente = IClienteService.findOne(id);
		else
			return "redirect:/app/listado-cliente";
		
		model.put("titulo", "Editar de Cliente");
		model.put("cliente",cliente);
		
		return "form";
	}
	
	
	
	
	
}
