package com.pie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pie.model.Competetion;

@Repository
public interface CompetetionRepository extends JpaRepository<Competetion, Integer>{
	
	Competetion findByUrl(String url);
	
}
