package edu.neu.coe.api.dao;

import java.util.ArrayList;
import java.util.List;

import edu.neu.coe.api.model.FoodRating;
import edu.neu.coe.api.model.Sight;


public interface IFoodRatingDAO {

	public void create(FoodRating foodRating);
	public FoodRating find(Integer id);
	public void update(FoodRating foodRating);
	public void delete(Integer id);
	public List<FoodRating> getAll();
	
}
