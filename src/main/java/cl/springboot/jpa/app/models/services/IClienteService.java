package cl.springboot.jpa.app.models.services;

import java.util.List;

import cl.springboot.jpa.app.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public boolean deleteOne(Cliente cliente);
}
