package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);

	@Autowired
	private ICiudadanoService ciudadanoService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		Ciudadano ciu1=new Ciudadano();
		ciu1.setNombre("Erick2");
		ciu1.setApellido("Solano2");
		
		
		Empleado empl1=new Empleado();
		empl1.setCodigoIess("12342");
		empl1.setSalario(new BigDecimal(1002));
		empl1.setCiudadano(ciu1);
		
		ciu1.setEmpleado(empl1);
		
		this.ciudadanoService.insertar(ciu1);
		
//		
//		Ciudadano ciu2=new Ciudadano();
//		ciu1.setNombre("Erick2");
//		ciu1.setApellido("Solano2");
//		
//		
//		Empleado empl2=new Empleado();
//		empl1.setCodigoIess("123422");
//		empl1.setSalario(new BigDecimal(10022));
//		empl1.setCiudadano(ciu2);
//		
//		ciu1.setEmpleado(empl2);
//		
		//this.ciudadanoService.insertar(empl2);
		
		
	}
}
