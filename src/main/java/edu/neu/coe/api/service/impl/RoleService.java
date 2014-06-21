package edu.neu.coe.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.api.dao.IRoleDAO;
import edu.neu.coe.api.dao.IUserDAO;
import edu.neu.coe.api.model.Role;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.service.IRoleService;
import edu.neu.coe.api.service.IUserService;
@Service("roleService")
@Transactional(readOnly = true)
public class RoleService implements IRoleService{

	@Autowired
	private IRoleDAO roleDAO;

	@Override
	@Transactional(readOnly = false)
	public void create(Role user) {
		roleDAO.create(user);
	}

	/*@Override
	@Transactional(readOnly = false)
	public User find(String username, String password) {
		for(User user:roleDAO.getAllUser()){
			if(user.getName().equals(username)&&user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}*/

	@Override
	@Transactional(readOnly = false)
	public List<Role> getAll() {
		return roleDAO.getAll();
	}

	@Override
	@Transactional
	public void update(Role e) {
		roleDAO.update(e);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		roleDAO.delete(id);
		
	}

	@Override
	@Transactional
	public Role find(Integer id) {
		return roleDAO.find(id);
	}

	@Override
	@Transactional
	public Role find(String name) {
		return roleDAO.get(name);
	}

	

}
