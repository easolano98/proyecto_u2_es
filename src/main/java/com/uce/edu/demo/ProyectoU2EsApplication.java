package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		// TODO Auto-generated method stub
		
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
		
		
		Vehiculo vehiculo2=new Vehiculo();
		vehiculo2.setIdVehi(1);
		vehiculo2.setMarca("Honda");
		vehiculo2.setPlaca("TTS0069");
		vehiculo2.setPrecio(new BigDecimal(2000));
		vehiculo2.setTipo("P");
		this.vehiculoService.actualizar(vehiculo2);
		
		
		//Si se le mapea el modelo matricula surge un error que no permite crear las tablas de propietario
		// o vehiculo, ni tampoco crear los datos
	}

}
