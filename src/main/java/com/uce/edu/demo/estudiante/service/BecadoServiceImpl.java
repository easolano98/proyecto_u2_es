package com.uce.edu.demo.estudiante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.repository.IBecadoRepository;
import com.uce.edu.demo.estudiante.repository.modelo.Becado;
@Service
public class BecadoServiceImpl implements IBecadoService {
	
	@Autowired
	private IBecadoRepository becadoRepository;
	
	
	@Override
	public void insertar(Becado becado) {
		// TODO Auto-generated method stub
		this.becadoRepository.insertar(becado);
	}

}
