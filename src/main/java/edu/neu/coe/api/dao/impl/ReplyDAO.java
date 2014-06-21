package edu.neu.coe.api.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.api.dao.IPhotoDAO;
import edu.neu.coe.api.dao.IReplyDAO;
import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Photo;
import edu.neu.coe.api.model.Reply;


@Repository
public class ReplyDAO implements IReplyDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Reply city) {
		sessionFactory.getCurrentSession().save(city);
	}

	@Override
	public Reply find(Integer id) {
		Reply e=(Reply) sessionFactory.getCurrentSession().get(Reply.class, id);
		return e;
	}

	@Override
	public void update(Reply city) {
		sessionFactory.getCurrentSession().saveOrUpdate(city);
	}
	
	@Override
	public void delete(Integer id) {
		Reply city=(Reply) sessionFactory.getCurrentSession().get(Reply.class, id);
		if(city!=null)
		sessionFactory.getCurrentSession().delete(city);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> getAll() {
		List<Reply> es=null;
		es=(List<Reply>)sessionFactory.getCurrentSession().createQuery("from Reply").list();
		return es;
	}

}
