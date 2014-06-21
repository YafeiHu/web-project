package edu.neu.coe.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.api.dao.IFoodRatingDAO;
import edu.neu.coe.api.dao.IUserDAO;
import edu.neu.coe.api.model.FoodRating;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.service.IFoodRatingService;
import edu.neu.coe.api.service.IUserService;
@Service("foodRatingService")
@Transactional(readOnly = true)
public class FoodRatingService implements IFoodRatingService{

	@Autowired
	private IFoodRatingDAO foodRatingDAO;

	@Override
	@Transactional(readOnly = false)
	public void create(FoodRating user) {
		foodRatingDAO.create(user);
	}

	/*@Override
	@Transactional(readOnly = false)
	public User find(String username, String password) {
		for(User user:foodRatingDAO.getAllUser()){
			if(user.getName().equals(username)&&user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}*/

	@Override
	@Transactional(readOnly = false)
	public List<FoodRating> getAll() {
		return foodRatingDAO.getAll();
	}

	@Override
	@Transactional
	public void update(FoodRating e) {
		foodRatingDAO.update(e);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		foodRatingDAO.delete(id);
		
	}
	@Override
	@Transactional
	public FoodRating find(Integer id) {
		return foodRatingDAO.find(id);
	}
	
	

}
