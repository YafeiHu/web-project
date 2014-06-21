package edu.neu.coe.api.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.api.dao.IPhotoDAO;
import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Photo;


@Repository
public class PhotoDAO implements IPhotoDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Photo city) {
		sessionFactory.getCurrentSession().save(city);
	}

	@Override
	public Photo find(Integer id) {
		Photo e=(Photo) sessionFactory.getCurrentSession().get(Photo.class, id);
		return e;
	}

	@Override
	public void update(Photo city) {
		sessionFactory.getCurrentSession().saveOrUpdate(city);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void delete(Integer id) {
		Photo city=(Photo) sessionFactory.getCurrentSession().get(Photo.class, id);
		if(city!=null)
		sessionFactory.getCurrentSession().delete(city);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> getAll() {
		List<Photo> es=null;
		es=(List<Photo>)sessionFactory.getCurrentSession().createQuery("from Photo").list();
		return es;
	}
	
	

}
