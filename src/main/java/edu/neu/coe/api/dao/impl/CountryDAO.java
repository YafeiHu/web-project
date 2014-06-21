package edu.neu.coe.api.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.api.dao.ICountryDAO;
import edu.neu.coe.api.dao.IFoodDAO;
import edu.neu.coe.api.model.Country;
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.User;

@Repository
public class CountryDAO implements ICountryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Country country) {
		sessionFactory.getCurrentSession().save(country);
	}

	@Override
	public Country find(Integer id) {
		Country country=(Country) sessionFactory.getCurrentSession().get(Country.class, id);
		return country;
	}

	@Override
	public void update(Country country) {
		sessionFactory.getCurrentSession().saveOrUpdate(country);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void delete(Integer id) {
		Country country=(Country) sessionFactory.getCurrentSession().get(Country.class, id);
		if(country!=null)
		sessionFactory.getCurrentSession().delete(country);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getAll() {
		List<Country> countrys=null;
		countrys=sessionFactory.getCurrentSession().createQuery("from Country").list();
		return countrys;
	}
}
