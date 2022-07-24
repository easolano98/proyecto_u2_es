package com.uce.edu.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.pedidoscliente.repository.modelo.Cliente;
import com.uce.edu.demo.pedidoscliente.repository.modelo.Pedido;
import com.uce.edu.demo.pedidoscliente.service.IClienteService;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);

	@Autowired
	private IClienteService clienteService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Insertar
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Emilia");
		cliente1.setApellido("Espinel");
		cliente1.setCedula("171515140");
		cliente1.setTelefono("0988492233");
		
		List<Pedido> pedido= new ArrayList<>();
		Pedido pedido1 = new Pedido();
		pedido1.setFechaSalida(LocalDateTime.now());
		pedido1.setFechaLlegada(LocalDateTime.of(2022, 10,10,18,20,2));
		pedido1.setProducto("Play Station");
		pedido1.setCliente(cliente1);
		pedido.add(pedido1);
		cliente1.setPedidos(pedido);
		
		this.clienteService.insertar(cliente1 );
	
		//Buscar
		Cliente cliente=this.clienteService.buscar(2);
		LOGGER.info("Buscando cliente "+cliente);
		
		//Actualizar
		Cliente clienteBuscar=this.clienteService.buscar(3);
		clienteBuscar.setNombre("Alexander");	
		this.clienteService.actualizar(clienteBuscar);
		
		//Eliminar
		this.clienteService.eliminar(2);
	}
}
