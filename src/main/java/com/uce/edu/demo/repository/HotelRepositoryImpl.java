package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetoone.Habitacion;
import com.uce.edu.demo.repository.modelo.onetoone.Hotel;
@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	
	
	
	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
	
		this.entityManager.persist(hotel);

		
	}

}
