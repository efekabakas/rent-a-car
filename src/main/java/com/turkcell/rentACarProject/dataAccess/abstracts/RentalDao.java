package com.turkcell.rentACarProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.rentACarProject.entities.concretes.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer> {
	
	List<Rental> findAllByCustomerId(int customerId);
	Rental findByCarIdAndReturnDateIsNull(int carId);
}
