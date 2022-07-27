package com.uce.edu.demo.debermtm.repository.modelo;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="autor2")
public class AutorDeber {
	@Id
	@Column(name="auto_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_id_seq")
	@SequenceGenerator(name = "auto_id_seq", sequenceName = "auto_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name="auto_nombre")
	private String nombre;
	
	@OneToMany(mappedBy="autor")
	private List<LibroAutor> libros;
	
	//SET y GET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<LibroAutor> getLibros() {
		return libros;
	}
	public void setLibros(List<LibroAutor> libros) {
		this.libros = libros;
	}
	
	
	
	
	
}
