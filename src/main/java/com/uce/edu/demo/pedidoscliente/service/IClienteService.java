package com.uce.edu.demo.pedidoscliente.service;

import com.uce.edu.demo.pedidoscliente.repository.modelo.Cliente;

public interface IClienteService {
	
	public void insertar(Cliente cliente);
	
	public Cliente buscar(Integer id);
	
	public void actualizar(Cliente cliente);
	
	public void eliminar(Integer id);
	
}
