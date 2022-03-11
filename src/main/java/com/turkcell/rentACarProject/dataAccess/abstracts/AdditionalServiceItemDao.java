package com.turkcell.rentACarProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.rentACarProject.entities.concretes.AdditionalServiceItem;

public interface AdditionalServiceItemDao extends JpaRepository<AdditionalServiceItem	, Integer>{

}
