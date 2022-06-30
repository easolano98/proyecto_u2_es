package com.uce.edu.demo.estudiante.service;

import com.uce.edu.demo.estudiante.to.EstudianteTo;

public interface IEstudianteJdbcService {
	
	
		public void ingresar(EstudianteTo e);
		
		public EstudianteTo buscar(int numCarnet);

		public void actualizar(EstudianteTo e);

		public void borrar(String cedula);
}
