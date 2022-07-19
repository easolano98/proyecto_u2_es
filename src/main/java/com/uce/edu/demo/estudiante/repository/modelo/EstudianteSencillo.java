package com.uce.edu.demo.estudiante.repository.modelo;

public class EstudianteSencillo {
	String apellido;
	String cedula;
	Integer id;

	public EstudianteSencillo(String apellido, String cedula, Integer id) {
		super();
		this.apellido = apellido;
		this.cedula = cedula;
		this.id = id;
	}

	public EstudianteSencillo() {

	}

	@Override
	public String toString() {
		return "EstudianteSencillo [apellido=" + apellido + ", cedula=" + cedula + ", id=" + id + "]";
	}

	// GET y SET
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
