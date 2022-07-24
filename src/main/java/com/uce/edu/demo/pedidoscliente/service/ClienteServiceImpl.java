package com.uce.edu.demo.pedidoscliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.pedidoscliente.repository.IClienteRepository;
import com.uce.edu.demo.pedidoscliente.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub

		this.clienteRepository.insertar(cliente);

	}

	@Override
	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.clienteRepository.buscar(id);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepository.actualizar(cliente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.clienteRepository.eliminar(id);
	}

}
