package com.turkcell.rentACarProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.rentACarProject.business.dtos.carDamage.ListCarDamageDto;
import com.turkcell.rentACarProject.entities.concretes.CarDamage;

public interface CarDamageDao extends JpaRepository<CarDamage, Integer>{
	
	List<ListCarDamageDto> getAllByCarId(int carId);
}
