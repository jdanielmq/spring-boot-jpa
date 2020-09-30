package cl.springboot.jpa.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.springboot.jpa.app.models.dao.IClienteDao;
import cl.springboot.jpa.app.models.entity.Cliente;

@Service
public class IClienteServiceImpl implements IClienteService {
	
	@Autowired
	IClienteDao IClienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return IClienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		IClienteDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return IClienteDao.findOne(id);
	}

	@Override
	@Transactional
	public boolean deleteOne(Cliente cliente) {
		IClienteDao.deleteOne(cliente);
		return true;
	}

}
