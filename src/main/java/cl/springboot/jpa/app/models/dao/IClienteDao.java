package cl.springboot.jpa.app.models.dao;

import java.util.List;

import cl.springboot.jpa.app.models.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();

}
