package edu.neu.coe.api.dao;

import java.util.ArrayList;
import java.util.List;

import edu.neu.coe.api.model.Country;
import edu.neu.coe.api.model.Sight;


public interface ICountryDAO {

	public void create(Country country);
	public Country find(Integer id);
	public void update(Country country);
	public void delete(Integer id);
	public List<Country> getAll();
	
}
