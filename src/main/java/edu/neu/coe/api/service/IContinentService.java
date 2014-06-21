package edu.neu.coe.api.service;

import java.io.Serializable;
import java.util.List;

import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Continent;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.model.Photo;

public interface IContinentService extends IAbstractService<Continent,Integer>{


	public List<Continent> getAll();
	public Continent get(String name);
}
