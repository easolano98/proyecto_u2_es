package com.uce.edu.demo.pedidoscliente.repository.modelo;

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
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedi_id_seq")
	@SequenceGenerator(name = "pedi_id_seq", sequenceName = "pedi_id_seq", allocationSize = 1)
	@Column(name="pedi_id")
	private Integer id;
	@Column(name="pedi_fecha_salida")
	private LocalDateTime fechaSalida;
	@Column(name="pedi_fecha_llegada")
	private LocalDateTime fechaLlegada;
	@Column(name="pedi_producto")
	private String producto;
	
	@ManyToOne()
	@JoinColumn(name="pedi_id_cliente")
	private Cliente cliente;
	
	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(LocalDateTime fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fechaSalida=" + fechaSalida + ", fechaLlegada=" + fechaLlegada + ", producto="
				+ producto + "]";
	}
	
	

}
