
package com.uce.edu.demo.correccion.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {
	@Id
	@Column(name = "matr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matr_id_seq")
	@SequenceGenerator(name = "matr_id_seq", sequenceName = "matr_id_seq", allocationSize = 1)
	private Integer idMatricula;
	@Column(name = "matr_fecha")
	private LocalDateTime fechaMatricula;
	@Column(name = "matr_valor_matricula")
	private BigDecimal valorMatricula;

	@ManyToOne()
	@JoinColumn(name = "matr_vehi_id")
	private Vehiculo vehiculo;

	@ManyToOne()
	@JoinColumn(name = "matr_prop_id")
	private Propietario propietario;

	// SET y GET
	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public BigDecimal getValorMatricula() {
		return valorMatricula;
	}

	public void setValorMatricula(BigDecimal valorMatricula) {
		this.valorMatricula = valorMatricula;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Integer getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}

	@Override
	public String toString() {
		return "Matricula [fechaMatricula=" + fechaMatricula + ", valorMatricula=" + valorMatricula + "]";
	}

}
