package com.pie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pie.model.CompetetionEntity;

@Repository
public interface CompetetionFieldRepository extends JpaRepository<CompetetionEntity, Integer> {
	
   List<CompetetionEntity> findByCompetetionid(int competetionid);
   
   void deleteAllByCompetetionid(int id);

}
