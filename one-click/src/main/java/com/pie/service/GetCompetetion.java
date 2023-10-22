package com.pie.service;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.pie.model.Competetion;

@Configurable
@Service
public class GetCompetetion {
	
	Competetion comp;
	public Competetion getComp() {
		return comp;
	}

	public void setComp(Competetion comp) {
		this.comp = comp;
	}

}
