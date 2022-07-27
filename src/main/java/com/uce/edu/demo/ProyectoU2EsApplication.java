package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.Detalle;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);

	@Autowired
	private IFacturaService facturaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Insertar

		Factura fact=this.facturaService.consultar(1);
		LOGGER.info("NUMERO "+fact.getNumero());
		LOGGER.info("FECHA "+fact.getFecha());
		LOGGER.info("CLIENTE "+fact.getCliente().getNumeroTarjeta());
		
		List<Detalle> detalles=fact.getDetalles();
		for (Detalle deta: detalles) {
			LOGGER.info("Detalle "+deta);
		}
		
	}
}
