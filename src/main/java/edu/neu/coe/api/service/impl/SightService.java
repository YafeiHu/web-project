package edu.neu.coe.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.api.dao.ISightDAO;
import edu.neu.coe.api.dao.IUserDAO;
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.service.ISightService;
import edu.neu.coe.api.service.IUserService;
@Service("sightService")
@Transactional(readOnly = true)
public class SightService implements ISightService{

	@Autowired
	private ISightDAO sightDAO;

	@Override
	@Transactional(readOnly = false)
	public void create(Sight user) {
		sightDAO.create(user);
	}

	/*@Override
	@Transactional(readOnly = false)
	public User find(String username, String password) {
		for(User user:sightDAO.getAllUser()){
			if(user.getName().equals(username)&&user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}*/

	@Override
	@Transactional(readOnly = false)
	public List<Sight> getAll() {
		return sightDAO.getAll();
	}

	@Override
	@Transactional
	public void update(Sight e) {
		sightDAO.update(e);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		sightDAO.delete(id);
		
	}

	@Override
	@Transactional
	public Sight find(Integer id) {
		return sightDAO.find(id);
	}

	@Override
	@Transactional
	public Sight get(String name) {
		for(Sight sight:sightDAO.getAll()){
			if(sight.getSightname().equals(name)){
				return sight;
			}
		}
		return null;
	}
	

}
