package edu.neu.coe.api.service;

import java.io.Serializable;
import java.util.List;

import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.User;

public interface IFoodService extends IAbstractService<Food,Integer>{

	
	public Food get(String name);
	public List<Food> getAll();
	
}
