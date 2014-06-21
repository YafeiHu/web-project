package edu.neu.coe.api.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.api.dao.ICityDAO;
import edu.neu.coe.api.dao.IFoodDAO;
import edu.neu.coe.api.dao.IFoodRatingDAO;
import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.FoodRating;
import edu.neu.coe.api.model.User;

@Repository
public class FoodRatingDAO implements IFoodRatingDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(FoodRating foodRating) {
		sessionFactory.getCurrentSession().save(foodRating);
	}

	@Override
	public FoodRating find(Integer id) {
		FoodRating foodRating=(FoodRating) sessionFactory.getCurrentSession().get(FoodRating.class, id);
		return foodRating;
	}

	@Override
	public void update(FoodRating foodRating) {
		sessionFactory.getCurrentSession().saveOrUpdate(foodRating);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void delete(Integer id) {
		FoodRating foodRating=(FoodRating) sessionFactory.getCurrentSession().get(FoodRating.class, id);
		if(foodRating!=null)
		sessionFactory.getCurrentSession().delete(foodRating);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FoodRating> getAll() {
		List<FoodRating> foodRatings=null;
		foodRatings=(List<FoodRating>)sessionFactory.getCurrentSession().createQuery("from FoodRating").list();
		return foodRatings;
	}
}
