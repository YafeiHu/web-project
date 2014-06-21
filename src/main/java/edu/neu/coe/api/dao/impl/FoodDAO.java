package edu.neu.coe.api.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.api.dao.IFoodDAO;
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.User;

@Repository
public class FoodDAO implements IFoodDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Food food) {
		sessionFactory.getCurrentSession().save(food);
	}

	@Override
	public Food find(Integer id) {
		Food food=(Food) sessionFactory.getCurrentSession().get(Food.class, id);
		return food;
	}

	@Override
	public void update(Food food) {
		sessionFactory.getCurrentSession().saveOrUpdate(food);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void delete(Integer id) {
		Food food=(Food) sessionFactory.getCurrentSession().get(Food.class, id);
		if(food!=null)
		sessionFactory.getCurrentSession().delete(food);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Food> getAll() {
		List<Food> foods=null;
		foods=(List<Food>)sessionFactory.getCurrentSession().createQuery("from Food").list();
		return foods;
	}
}
