package com.uce.edu.demo.pedidoscliente.repository;

import java.util.List;

import com.uce.edu.demo.pedidoscliente.repository.modelo.Cliente;

public interface IClienteRepository {
	
	public void insertar(Cliente cliente);
	
	public Cliente buscar(Integer id);
	
	public void actualizar(Cliente cliente);
	
	public void eliminar(Integer id);
	
	public List<Cliente> buscarCedula(String cedula);
	
}
