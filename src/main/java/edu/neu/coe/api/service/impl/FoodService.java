package edu.neu.coe.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.api.dao.IFoodDAO;
import edu.neu.coe.api.dao.IUserDAO;
import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.service.IFoodService;
import edu.neu.coe.api.service.IUserService;
@Service("foodService")
@Transactional(readOnly = true)
public class FoodService implements IFoodService{

	@Autowired
	private IFoodDAO foodDAO;

	@Override
	@Transactional(readOnly = false)
	public void create(Food user) {
		foodDAO.create(user);
	}

	/*@Override
	@Transactional(readOnly = false)
	public User find(String username, String password) {
		for(Food user:foodDAO.getAll()){
			if(user.getName().equals(username)&&user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}*/

	@Override
	@Transactional(readOnly = false)
	public List<Food> getAll() {
		return foodDAO.getAll();
	}

	@Override
	@Transactional
	public void update(Food e) {
		foodDAO.update(e);
		
	}

	@Override
	public void delete(Integer id) {
		foodDAO.delete(id);
		
	}

	@Override
	public Food find(Integer id) {
		return foodDAO.find(id);
	}
	
	@Override
	@Transactional
	public Food get(String name) {
		for(Food food:foodDAO.getAll()){
			if(food.getFoodname().equals(name)){
				return food;
			}
		}
		return null;
	}

}
