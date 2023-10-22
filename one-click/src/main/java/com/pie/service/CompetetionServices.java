package com.pie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pie.dao.CompetetionFieldRepository;
import com.pie.dao.CompetetionRepository;
import com.pie.dao.UserRepository;
import com.pie.model.Competetion;
import com.pie.model.CompetetionEntity;

@Configurable
@Service
@Transactional
public class CompetetionServices {

	@Autowired
	private CompetetionRepository icomp;

	@Autowired
	private CompetetionFieldRepository ientity;


	public List<Competetion> getCompetetionList() {
		return icomp.findAll();
	}

	public Competetion getCompetetionbyId(int id) {
		Competetion comp = icomp.getById(id);
		return comp;
	}

	public void deleteCompetetion(int id) {
		icomp.deleteById(id);
		ientity.deleteAllByCompetetionid(id);
	}

	public List<CompetetionEntity> getcompetetionentity(int id) {
		return ientity.findByCompetetionid(id);
	}

	public void editCompetetion(EntityWrapper entityWrapper) {
		
		//icomp.save(comp);
		//ientity.deleteAllByCompetetionid(comp.getId());
		ientity.saveAll(entityWrapper.getEntityList());
		
	}
	
	
	public void addCompetetionAndEntities(Competetion comp,EntityWrapper wrapper) {
		Competetion comp2 = icomp.save(comp);
		int id = comp2.getId();
		addEntities(wrapper.getEntityList(),id);
	}

	public EntityWrapper createwrapper(int a) {
		EntityWrapper entityWrapper = new EntityWrapper();
		for (int i = 0; i < a; i++) {
			entityWrapper.add(new CompetetionEntity());
		}
		return entityWrapper;
	}

	public void addEntities(List<CompetetionEntity> ls,int id)  {
		try {
		for (CompetetionEntity competetionentity : ls) {
			competetionentity.setCompetetionid(id);
			ientity.save(competetionentity);
		}
		}
		catch(Exception ex) {
			icomp.deleteById(id);
			throw ex;
		}
	}

}

