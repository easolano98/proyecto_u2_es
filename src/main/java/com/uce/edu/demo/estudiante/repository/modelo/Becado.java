package com.uce.edu.demo.estudiante.repository.modelo;

import java.math.BigDecimal;

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

@Entity
@Table(name ="becado")
public class Becado {
	@Id
	@Column(name="beca_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beca_id_seq")
	@SequenceGenerator(name = "beca_id_seq", sequenceName = "beca_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name="beca_monto")
	private BigDecimal monto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="beca_id_estudiante")
	private Estudiante estudiante;

	
	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	
	
	
}
