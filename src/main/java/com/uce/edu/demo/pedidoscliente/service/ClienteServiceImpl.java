package com.uce.edu.demo.pedidoscliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.pedidoscliente.repository.IClienteRepository;
import com.uce.edu.demo.pedidoscliente.repository.IPedidoRepository;
import com.uce.edu.demo.pedidoscliente.repository.modelo.Cliente;
import com.uce.edu.demo.pedidoscliente.repository.modelo.Pedido;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IPedidoRepository pedidoRepository;
	
	
	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		List<Pedido>pedidosLista=cliente.getPedidos();
		cliente.setPedidos(null);
		this.clienteRepository.insertar(cliente);
	
		List<Cliente> clienteBuscar=this.buscarCedula(cliente.getCedula());
		Cliente cliente1= clienteBuscar.get(clienteBuscar.size()-1);
		for(Pedido pedidoItem: pedidosLista) {
			pedidoItem.setCliente(cliente1);
			this.pedidoRepository.insertar(pedidoItem);
		}
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

	@Override
	public List<Cliente> buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepository.buscarCedula(cedula);
	}

}
