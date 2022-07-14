package com.uce.edu.demo.estudiante.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="estudiante")

//Named
@NamedQuery(name="Estudiante.eliminarPorNombre", query="DELETE FROM Estudiante e WHERE e.nombre= :datoNombre ")
@NamedQuery(name="Estudiante.actualizarCarreraPorCarnet", query="UPDATE Estudiante e SET e.carrera= :datoCarrera WHERE e.numCarnet= :datoCarnet ")

//Typed Named
@NamedQuery(name="Estudiante.buscarApellidoOrden", query="SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido ORDER BY e.nombre")
@NamedQuery(name="Estudiante.buscarPorLetra", query="SELECT e FROM Estudiante e WHERE  e.apellido LIKE :datoLetra ")

//Named Native
@NamedNativeQuery(name="Estudiante.buscarPorCedulaNative", query="SELECT * FROM estudiante WHERE estu_cedula= :datoCedula" ,resultClass=Estudiante.class)
@NamedNativeQuery(name="Estudiante.buscarPorLetraNative", query="SELECT * FROM estudiante WHERE estu_apellido LIKE :datoLetra", resultClass=Estudiante.class)




public class Estudiante {
	
	@Id
	@Column(name = "estu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estu_id_seq")
	@SequenceGenerator(name = "estu_id_seq", sequenceName = "estu_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name="estu_num_carnet")
	private Integer numCarnet;
	@Column(name="estu_cedula")
	private String cedula;
	@Column(name="estu_nombre")
	private String nombre;
	@Column(name="estu_apellido")
	private String apellido;
	@Column(name="estu_carrera")
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
