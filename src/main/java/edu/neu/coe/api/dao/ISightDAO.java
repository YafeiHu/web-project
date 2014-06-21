package edu.neu.coe.api.dao;

import java.util.ArrayList;
import java.util.List;

import edu.neu.coe.api.model.Sight;


public interface ISightDAO {

	public void create(Sight sight);
	public Sight find(Integer id);
	public void update(Sight sight);
	public void delete(Integer id);
	public List<Sight> getAll();
	
}
