package edu.neu.coe.api.service;

import java.io.Serializable;
import java.util.List;

import edu.neu.coe.api.model.SightRating;
import edu.neu.coe.api.model.User;

public interface ISightRatingService extends IAbstractService<SightRating,Integer>{


	public List<SightRating> getAll();
	
}
