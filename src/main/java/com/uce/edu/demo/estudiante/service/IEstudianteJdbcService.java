package com.uce.edu.demo.estudiante.service;

import com.uce.edu.demo.estudiante.to.Estudiante;

public interface IEstudianteJdbcService {
	
	
		public void ingresar(Estudiante e);
		
		public Estudiante buscar(int numCarnet);

		public void actualizar(Estudiante e);

		public void borrar(String cedula);
}
