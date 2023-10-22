package com.pie.service;

import java.util.ArrayList;
import java.util.List;

import com.pie.model.CompetetionEntity;

public class EntityWrapper {
	private List<CompetetionEntity> entityList;

	public EntityWrapper() {
		this.entityList = new ArrayList<CompetetionEntity>();
	}

	public List<CompetetionEntity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<CompetetionEntity> entityList) {
		this.entityList = entityList;
	}

	public void add(CompetetionEntity foo) {
		this.entityList.add(foo);
	}
}
