package com.uce.edu.demo.estudiante.to;

public class Estudiante {
	private String cedula;
	private String nombre;
	private String apellido;
	private int numCarnet;
	private String carrera;
	
	public Estudiante() {
		
	}
	
	
	public Estudiante(String cedula, String nombre, String apellido, int numCarnet, String carrera) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numCarnet = numCarnet;
		this.carrera = carrera;
	}
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
