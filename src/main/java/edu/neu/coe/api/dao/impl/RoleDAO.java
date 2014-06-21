package edu.neu.coe.api.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.coe.api.dao.ICityDAO;
import edu.neu.coe.api.dao.IFoodDAO;
import edu.neu.coe.api.dao.IRoleDAO;
import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.Role;
import edu.neu.coe.api.model.User;

@Repository
public class RoleDAO implements IRoleDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}

	@Override
	public Role find(Integer id) {
		Role city=(Role) sessionFactory.getCurrentSession().get(Role.class, id);
		return city;
	}

	@Override
	public void update(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void delete(Integer id) {
		Role role=(Role) sessionFactory.getCurrentSession().get(Role.class, id);
		if(role!=null)
		sessionFactory.getCurrentSession().delete(role);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAll() {
		List<Role> roles=null;
		roles=(List<Role>)sessionFactory.getCurrentSession().createQuery("from Role").list();
		return roles;
	}
	
	@SuppressWarnings("unchecked")
	public Role get(String name){
		Query q=sessionFactory.getCurrentSession().createQuery("from Role where rolename=:name");
		q.setString("name", name);
		List<Role> es=null;
		es=q.list();
		if(es.size()>0){
			return es.get(0);
		}
		else return null;
		
	}
}
