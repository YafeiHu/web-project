package edu.neu.coe.api.service;

import java.io.Serializable;
import java.util.List;

import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.User;

public interface ISightService extends IAbstractService<Sight,Integer>{

	
	public Sight get(String name);
	public List<Sight> getAll();
	
}
