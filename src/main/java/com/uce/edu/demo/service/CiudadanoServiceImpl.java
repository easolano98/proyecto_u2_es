package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudanoRepository;
import com.uce.edu.demo.repository.modelo.Ciudadano;
@Service
public class CiudadanoServiceImpl implements ICiudadanoService {
	
	@Autowired
	private ICiudanoRepository ciudanoRepository;
	
	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		
		this.ciudanoRepository.insertar(ciudadano);
	}

}
