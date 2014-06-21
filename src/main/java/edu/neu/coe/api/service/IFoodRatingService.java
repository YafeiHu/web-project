package edu.neu.coe.api.service;

import java.io.Serializable;
import java.util.List;

import edu.neu.coe.api.model.FoodRating;
import edu.neu.coe.api.model.User;

public interface IFoodRatingService extends IAbstractService<FoodRating,Integer>{

	public List<FoodRating> getAll();
	
}
