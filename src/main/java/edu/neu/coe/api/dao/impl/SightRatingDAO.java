package edu.neu.coe.api.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.api.dao.ICityDAO;
import edu.neu.coe.api.dao.IFoodDAO;
import edu.neu.coe.api.dao.ISightRatingDAO;
import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.SightRating;
import edu.neu.coe.api.model.User;

@Repository
public class SightRatingDAO implements ISightRatingDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(SightRating city) {
		sessionFactory.getCurrentSession().save(city);
	}

	@Override
	public SightRating find(Integer id) {
		SightRating city=(SightRating) sessionFactory.getCurrentSession().get(SightRating.class, id);
		return city;
	}

	@Override
	public void update(SightRating city) {
		sessionFactory.getCurrentSession().saveOrUpdate(city);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void delete(Integer id) {
		SightRating city=(SightRating) sessionFactory.getCurrentSession().get(SightRating.class, id);
		if(city!=null)
		sessionFactory.getCurrentSession().delete(city);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SightRating> getAll() {
		List<SightRating> citys=null;
		citys=(List<SightRating>)sessionFactory.getCurrentSession().createQuery("from SightRating").list();
		return citys;
	}
}
