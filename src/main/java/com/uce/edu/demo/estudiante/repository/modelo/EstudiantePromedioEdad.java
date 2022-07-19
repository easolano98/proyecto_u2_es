package com.uce.edu.demo.estudiante.repository.modelo;

public class EstudiantePromedioEdad {

	private String carrera;

	private Double promedio;

	public EstudiantePromedioEdad() {

	}

	public EstudiantePromedioEdad(String carrera, Double promedio) {
		super();
		this.carrera = carrera;
		this.promedio = promedio;
	}

	@Override
	public String toString() {
		return "EstudianteContador [carrera=" + carrera + ", promedio=" + promedio + "]";
	}

	// GET y SET
	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

}
