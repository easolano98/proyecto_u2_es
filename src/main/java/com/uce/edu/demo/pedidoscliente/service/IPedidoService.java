package com.uce.edu.demo.pedidoscliente.service;

import com.uce.edu.demo.pedidoscliente.repository.modelo.Pedido;

public interface IPedidoService {
	public void insertar(Pedido pedido);
	
	public Pedido buscar(Integer id);
	
	public void actualizar(Pedido pedido);
	
	public void eliminar(Integer id);
}
