package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.correccion.repository.modelo.Matricula;
import com.uce.edu.demo.correccion.repository.modelo.Propietario;
import com.uce.edu.demo.correccion.repository.modelo.Vehiculo;
import com.uce.edu.demo.correccion.service.IMatriculaGestorService;
import com.uce.edu.demo.correccion.service.IPropietarioService;
import com.uce.edu.demo.correccion.service.IVehiculoService;

@SpringBootApplication
public class ProyectoU2EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);

	@Autowired
	private IVehiculoService vehiculoService;

	@Autowired
	private IPropietarioService propietarioService;

	@Autowired	
	private IMatriculaGestorService gestorService;

	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Insertar

		Vehiculo vehiculo=new Vehiculo();
		vehiculo.setMarca("Mazda");
		vehiculo.setPlaca("LEO1923");
		vehiculo.setPrecio(new BigDecimal(60000));
		vehiculo.setTipo("P");

		this.vehiculoService.insertar(vehiculo);


		Propietario propietario=new Propietario();
		propietario.setNombre("Oscar");
		propietario.setApellido("Marmol");
		propietario.setCedula("15201923");
		this.propietarioService.crear(propietario);
		
		
		Matricula matricula = new Matricula();
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setPropietario(propietario);
		matricula.setVehiculo(vehiculo);
		this.gestorService.generar(propietario.getCedula(), vehiculo.getPlaca());
	}
}
