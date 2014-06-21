package edu.neu.coe.api.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.api.dao.ICityDAO;
import edu.neu.coe.api.dao.IFoodDAO;
import edu.neu.coe.api.dao.ISightDAO;
import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.User;

@Repository
public class SightDAO implements ISightDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Sight sight) {
		sessionFactory.getCurrentSession().save(sight);
	}

	@Override
	public Sight find(Integer id) {
		Sight sight=(Sight) sessionFactory.getCurrentSession().get(Sight.class, id);
		return sight;
	}

	@Override
	public void update(Sight sight) {
		sessionFactory.getCurrentSession().saveOrUpdate(sight);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void delete(Integer id) {
		Sight sight=(Sight) sessionFactory.getCurrentSession().get(Sight.class, id);
		if(sight!=null)
		sessionFactory.getCurrentSession().delete(sight);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sight> getAll() {
		List<Sight> sights=null;
		sights=(List<Sight>)sessionFactory.getCurrentSession().createQuery("from Sight").list();
		return sights;
	}
}
