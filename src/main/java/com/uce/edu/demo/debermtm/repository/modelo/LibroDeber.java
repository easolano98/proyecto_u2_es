package com.uce.edu.demo.debermtm.repository.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="libro2")
public class LibroDeber {
	@Id
	@Column(name="libr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libr_id_seq")
	@SequenceGenerator(name = "libr_id_seq", sequenceName = "libr_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name="libr_titulo")
	private String titulo;
	@Column(name="libr_cantidad_paginas")
	private Integer cantidadPaginas;
	
	@OneToMany(mappedBy="libro")
	private List<LibroAutor>autores;
	
	//GET SET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getCantidadPaginas() {
		return cantidadPaginas;
	}
	public void setCantidadPaginas(Integer cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}
	public List<LibroAutor> getAutores() {
		return autores;
	}
	public void setAutores(List<LibroAutor> autores) {
		this.autores = autores;
	}
	
	
	
	
	
}
