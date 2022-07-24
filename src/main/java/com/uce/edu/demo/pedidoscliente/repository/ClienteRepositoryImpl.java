package com.uce.edu.demo.pedidoscliente.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.pedidoscliente.repository.modelo.Cliente;
@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Cliente cliente=this.buscar(id);
		this.entityManager.remove(cliente);
	}

}
