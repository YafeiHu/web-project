package edu.neu.coe.api.dao;

import java.util.ArrayList;
import java.util.List;

import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Sight;


public interface ICityDAO {

	public void create(City city);
	public City find(Integer id);
	public void update(City city);
	public void delete(Integer id);
	public List<City> getAll();
	
}
