package com.uce.edu.demo.estudiante.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Estudiante {
	
	@Id
	@Column(name="num_carnet")
	private Integer numCarnet;
	@Column(name="cedula")
	private String cedula;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="carrera")
	private String carrera;
	
	
	//SET y GET
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	public int getNumCarnet() {
		return numCarnet;
	}
	public void setNumCarnet(int numCarnet) {
		this.numCarnet = numCarnet;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}


	@Override
	public String toString() {
		return "Estudiante [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", numCarnet="
				+ numCarnet + ", carrera=" + carrera + "]";
	}
	
	
}
