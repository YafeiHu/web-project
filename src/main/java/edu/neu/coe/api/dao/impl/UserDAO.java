package edu.neu.coe.api.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.api.dao.IUserDAO;
import edu.neu.coe.api.model.User;

@Repository
public class UserDAO implements IUserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User find(Integer id) {
		User user=(User) sessionFactory.getCurrentSession().get(User.class, id);
		return user;
	}

	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void delete(Integer id) {
		User user=(User) sessionFactory.getCurrentSession().get(User.class, id);
		if(user!=null)
		sessionFactory.getCurrentSession().delete(user);
		sessionFactory.getCurrentSession().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		List<User> users=null;
		users=(List<User>)sessionFactory.getCurrentSession().createQuery("from User").list();
		System.out.println(users.size());
		return users;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User get(String name){
		Query q=sessionFactory.getCurrentSession().createQuery("from User where name=:name");
		q.setString("name", name);
		List<User> users=null;
		users=q.list();
		if(users.size()>0){
			System.out.println("aaaa"+users.get(0).getName());
			return users.get(0);
			
		}
		else return null;
		
	}

}
