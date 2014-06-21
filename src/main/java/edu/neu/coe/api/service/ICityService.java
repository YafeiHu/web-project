package edu.neu.coe.api.service;

import java.io.Serializable;
import java.util.List;

import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Continent;
import edu.neu.coe.api.model.User;

public interface ICityService extends IAbstractService<City,Integer>{

	public City get(String name);
}
