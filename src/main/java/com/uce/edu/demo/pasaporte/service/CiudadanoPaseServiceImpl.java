package com.uce.edu.demo.pasaporte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.pasaporte.repository.ICiudanoPasaporteRepository;
import com.uce.edu.demo.pasaporte.repository.modelo.CiudadanoPasaporte;

@Service
public class CiudadanoPaseServiceImpl implements ICiudadanoPasaporteService {

	@Autowired
	private ICiudanoPasaporteRepository ciudanoPasaporteRepository;

	@Override
	public void insertar(CiudadanoPasaporte ciudadano) {
		// TODO Auto-generated method stub
		this.ciudanoPasaporteRepository.insertar(ciudadano);
	}

	@Override
	public void actualizar(CiudadanoPasaporte ciudadano) {
		// TODO Auto-generated method stub
		this.ciudanoPasaporteRepository.actualizar(ciudadano);
	}


	@Override
	public CiudadanoPasaporte buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudanoPasaporteRepository.buscar(cedula);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.ciudanoPasaporteRepository.eliminar(id);
	}

	@Override
	public int eliminarPorCed(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudanoPasaporteRepository.eliminarPorCed(cedula);
	}

	
	

}
