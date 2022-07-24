package com.uce.edu.demo.pedidoscliente.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.pedidoscliente.repository.modelo.Pedido;
@Repository
@Transactional
public class PedidoRepositoryImpl implements IPedidoRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void insertar(Pedido pedido) {
		// TODO Auto-generated method stub
		this.entityManager.persist(pedido);
	}

	@Override
	public Pedido buscar(Integer id) {
		// TODO Auto-generated method stub
		
		return this.entityManager.find(Pedido.class, id);
	}

	@Override
	public void actualizar(Pedido pedido) {
		// TODO Auto-generated method stub
		this.entityManager.merge(pedido);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Pedido pedido=this.buscar(id);
		this.entityManager.remove(pedido);
	}
	
	
	
}
