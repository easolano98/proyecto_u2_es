package com.uce.edu.demo.correccion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.correccion.repository.IMatriculaRepository;
import com.uce.edu.demo.correccion.repository.IPropietarioRepository;
import com.uce.edu.demo.correccion.repository.IVehiculoRepository;
import com.uce.edu.demo.correccion.repository.modelo.Matricula;
import com.uce.edu.demo.correccion.repository.modelo.Propietario;
import com.uce.edu.demo.correccion.repository.modelo.Vehiculo;

@Service
public class MatriculaGestorServiceImpl implements IMatriculaGestorService {
	@Autowired
	private IPropietarioRepository propietarioRepository;
	
	@Autowired
	private IVehiculoRepository vehiculoRepository;
	@Autowired
	@Qualifier("pesado")
	private IMatriculaService matriculaServicePesado;
	@Autowired
	@Qualifier("liviano")
	private IMatriculaService matriculaServiceLiviano;

	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	@Override
	public void generar(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario prop=this.propietarioRepository.consultar(cedula);
		Vehiculo vehi=this.vehiculoRepository.buscar(placa);
		String tipo=vehi.getTipo();
		BigDecimal valorMatricula;
		if(tipo.equals("P")) {
			valorMatricula=this.matriculaServicePesado.calcular(vehi.getPrecio());
		}else {
			valorMatricula=this.matriculaServiceLiviano.calcular(vehi.getPrecio());
		}
		
		if(valorMatricula.compareTo(new BigDecimal(2000))>0) {
			BigDecimal valorDescuento=valorMatricula.multiply(new BigDecimal(7)).divide(new BigDecimal(100));
			valorMatricula=valorMatricula.subtract(valorDescuento);
		}
		Matricula matricula=new Matricula();
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setValorMatricula(valorMatricula);
		matricula.setPropietario(prop);
		matricula.setVehiculo(vehi);
		
		this.matriculaRepository.crear(matricula);
	}
	
}
