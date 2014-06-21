package edu.neu.coe.api.dao;

import java.util.ArrayList;
import java.util.List;

import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Continent;
import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.Photo;


public interface IContinentDAO {

	public void create(Continent city);
	public Continent find(Integer id);
	public void update(Continent city);
	public void delete(Integer id);
	public List<Continent> getAll();
	
}
