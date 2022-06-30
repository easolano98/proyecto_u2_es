package com.uce.edu.demo.estudiante.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoU2EsApplication;
import com.uce.edu.demo.estudiante.to.EstudianteTo;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2EsApplication.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update(
				"insert into estudiante (num_carnet, cedula, nombre, apellido, carrera) values (?,?,?,?,?)",
				new Object[] { estudiante.getNumCarnet(), estudiante.getCedula(), estudiante.getNombre(),
						estudiante.getApellido(), estudiante.getCarrera() });
		LOGGER.info("Se agrego "+estudiante);
	}

	@Override
	public EstudianteTo buscar(int numCarnet) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject("select * from estudiante where num_carnet=?", new Object[] { numCarnet },
				new BeanPropertyRowMapper<EstudianteTo>(EstudianteTo.class));
		
	}

	@Override
	public void actualizar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update estudiante set cedula=?,nombre=?,apellido=?,carrera=? where num_carnet=?",
				new Object[] { estudiante.getCedula(), estudiante.getNombre(), estudiante.getApellido(),
						estudiante.getCarrera(), estudiante.getNumCarnet() });
		LOGGER.info("Se actualizo "+estudiante);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from estudiante where cedula=?", new Object[] { cedula });
		LOGGER.info("Se agrego "+cedula);
	}

}
