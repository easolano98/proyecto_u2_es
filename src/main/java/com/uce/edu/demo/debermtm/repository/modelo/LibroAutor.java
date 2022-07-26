package com.uce.edu.demo.debermtm.repository.modelo;

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
@Table(name="autor_libro")
public class LibroAutor {
	
	@Id
	@Column(name="auli_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auli_id_seq")
	@SequenceGenerator(name = "auli_id_seq", sequenceName = "auli_id_seq", allocationSize = 1)
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="auli_id_libro")
	private LibroDeber libro;
	
	@ManyToOne
	@JoinColumn(name="auli_id_autor")
	private AutorDeber autor;

	
	//SET y GET
	public LibroDeber getLibro() {
		return libro;
	}

	public void setLibro(LibroDeber libro) {
		this.libro = libro;
	}

	public AutorDeber getAutor() {
		return autor;
	}

	public void setAutor(AutorDeber autor) {
		this.autor = autor;
	}

	
	

	
	
	
	
	
	
}
