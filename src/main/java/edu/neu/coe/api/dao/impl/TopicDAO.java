package edu.neu.coe.api.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.api.dao.IPhotoDAO;
import edu.neu.coe.api.dao.ITopicDAO;
import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Photo;
import edu.neu.coe.api.model.Topic;


@Repository
public class TopicDAO implements ITopicDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Topic city) {
		sessionFactory.getCurrentSession().save(city);
	}

	@Override
	public Topic find(Integer id) {
		Topic e=(Topic) sessionFactory.getCurrentSession().get(Topic.class, id);
		return e;
	}

	@Override
	public void update(Topic city) {
		sessionFactory.getCurrentSession().saveOrUpdate(city);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void delete(Integer id) {
		Topic city=(Topic) sessionFactory.getCurrentSession().get(Topic.class, id);
		if(city!=null)
		sessionFactory.getCurrentSession().delete(city);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> getAll() {
		List<Topic> es=null;
		es=(List<Topic>)sessionFactory.getCurrentSession().createQuery("from Topic").list();
		return es;
	}

}
