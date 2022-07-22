package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.pasaporte.repository.modelo.CiudadanoPasaporte;
import com.uce.edu.demo.pasaporte.repository.modelo.Pasaporte;
import com.uce.edu.demo.pasaporte.service.ICiudadanoPasaporteService;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);

	@Autowired
	private ICiudadanoPasaporteService ciudadanoPasaporteService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		CiudadanoPasaporte ciud1=new CiudadanoPasaporte();
//		
		ciud1.setNombre("Billy");
		ciud1.setApellido("Perez");
		ciud1.setCedula("1511720211");
		ciud1.setFechaNacimiento(LocalDateTime.of(1985, 3,15,11,20,2));
		
		Pasaporte pase1=new Pasaporte();
		pase1.setNumero("3000");
		pase1.setFechaEmision(LocalDateTime.now());
		pase1.setFechaCaducidad(LocalDateTime.of(2027, 11,11,18,20,2));
		pase1.setCiudadanoPasaporte(ciud1);
		
		ciud1.setPasaporte(pase1);
		LOGGER.info("Se creo ciudadano");
		this.ciudadanoPasaporteService.insertar(ciud1);


		LOGGER.info("Se actualizo ciudadano");
		CiudadanoPasaporte ciud2=new CiudadanoPasaporte();
		ciud2.setId(14);
		ciud2.setNombre("Paulina");
		ciud2.setApellido("Tamyo");
		ciud2.setCedula("15202311");
		ciud2.setFechaNacimiento(LocalDateTime.of(2000, 3,15,11,20,2));
		
		Pasaporte pase2=new Pasaporte();
		pase2.setId(14);
		pase2.setNumero("0009");
		pase2.setFechaEmision(LocalDateTime.now());
		pase2.setFechaCaducidad(LocalDateTime.of(2022, 12,11,18,20,2));
		pase2.setCiudadanoPasaporte(ciud2);
		
		ciud2.setPasaporte(pase2);
		
		this.ciudadanoPasaporteService.actualizar(ciud2);
//		
		
		CiudadanoPasaporte ciud=this.ciudadanoPasaporteService.buscar("1500080211");
		LOGGER.info("Busqueda del ciudadano "+ciud);
		
		LOGGER.info("Se elimino ciudadano");
		this.ciudadanoPasaporteService.eliminar(9);
		
		
		
		
	}
}
