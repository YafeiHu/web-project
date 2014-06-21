package edu.neu.coe.api.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.api.dao.IContinentDAO;
import edu.neu.coe.api.dao.IPhotoDAO;
import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Continent;
import edu.neu.coe.api.model.Photo;


@Repository
public class ContinentDAO implements IContinentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Continent city) {
		sessionFactory.getCurrentSession().save(city);
	}

	@Override
	public Continent find(Integer id) {
		Continent e=(Continent) sessionFactory.getCurrentSession().get(Continent.class, id);
		return e;
	}

	@Override
	public void update(Continent city) {
		sessionFactory.getCurrentSession().saveOrUpdate(city);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void delete(Integer id) {
		Continent city=(Continent) sessionFactory.getCurrentSession().get(Continent.class, id);
		if(city!=null)
		sessionFactory.getCurrentSession().delete(city);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Continent> getAll() {
		List<Continent> es=null;
		es=(List<Continent>)sessionFactory.getCurrentSession().createQuery("from Continent").list();
		return es;
	}

}
