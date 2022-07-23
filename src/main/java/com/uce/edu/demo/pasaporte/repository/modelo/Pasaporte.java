package com.uce.edu.demo.pasaporte.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.uce.edu.demo.pasaporte.repository.modelo.CiudadanoPasaporte;

@Entity
@Table(name = "Pasaporte")
public class Pasaporte {
	@Id
	@Column(name = "pase_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pase_id_seq")
	@SequenceGenerator(name = "pase_id_seq", sequenceName = "pase_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "pase_numero")
	private String numero;
	@Column(name = "pase_fecha_emision")
	private LocalDateTime fechaEmision;
	@Column(name = "pase_fecha_caducidad")
	private LocalDateTime fechaCaducidad;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pase_id_ciudadano")
	private CiudadanoPasaporte ciudadanoPasaporte;

	//SET 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public LocalDateTime getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDateTime fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public CiudadanoPasaporte getCiudadanoPasaporte() {
		return ciudadanoPasaporte;
	}

	public void setCiudadanoPasaporte(CiudadanoPasaporte ciudadanoPasaporte) {
		this.ciudadanoPasaporte = ciudadanoPasaporte;
	}

	@Override
	public String toString() {
		return "Pasaporte [id=" + id + ", numero=" + numero + ", fechaEmision=" + fechaEmision + ", fechaCaducidad="
				+ fechaCaducidad + ", ciudadanoPasaporte=" + ciudadanoPasaporte + "]";
	}

	
}
