package edu.neu.coe.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.api.dao.IUserDAO;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.service.IUserService;
@Service("userService")
@Transactional(readOnly = true)
public class UserService implements IUserService{

	@Autowired
	private IUserDAO userDAO;

	@Override
	@Transactional(readOnly = false)
	public void create(User user) {
		userDAO.create(user);
	}

	@Override
	@Transactional(readOnly = false)
	public User find(String name) {
		return userDAO.get(name);
	}

	@Override
	@Transactional(readOnly = false)
	public List<User> getAll() {
		return userDAO.getAll();
	}

	@Override
	@Transactional
	public void update(User e) {
		userDAO.update(e);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		userDAO.delete(id);
		
	}

	@Override
	@Transactional
	public User find(Integer id) {
		// TODO Auto-generated method stub
		return userDAO.find(id);
	}

	

}
