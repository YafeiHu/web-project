package edu.neu.coe.api.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.api.dao.ICityDAO;
import edu.neu.coe.api.dao.IFoodDAO;
import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.User;

@Repository
public class CityDAO implements ICityDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(City city) {
		sessionFactory.getCurrentSession().save(city);
	}

	@Override
	public City find(Integer id) {
		City city=(City) sessionFactory.getCurrentSession().get(City.class, id);
		return city;
	}

	@Override
	public void update(City city) {
		sessionFactory.getCurrentSession().saveOrUpdate(city);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void delete(Integer id) {
		City city=(City) sessionFactory.getCurrentSession().get(City.class, id);
		if(city!=null)
		sessionFactory.getCurrentSession().delete(city);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getAll() {
		List<City> citys=null;
		citys=(List<City>)sessionFactory.getCurrentSession().createQuery("from City").list();
		return citys;
	}
}
