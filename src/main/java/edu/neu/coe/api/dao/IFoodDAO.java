package edu.neu.coe.api.dao;

import java.util.ArrayList;
import java.util.List;

import edu.neu.coe.api.model.Food;

public interface IFoodDAO {

	public void create(Food food);
	public Food find(Integer id);
	public void update(Food food);
	public void delete(Integer id);
	public List<Food> getAll();
}
