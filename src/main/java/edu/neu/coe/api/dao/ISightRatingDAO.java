package edu.neu.coe.api.dao;

import java.util.ArrayList;
import java.util.List;

import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.SightRating;


public interface ISightRatingDAO {

	public void create(SightRating sightRating);
	public SightRating find(Integer id);
	public void update(SightRating sight);
	public void delete(Integer id);
	public List<SightRating> getAll();
	
}
