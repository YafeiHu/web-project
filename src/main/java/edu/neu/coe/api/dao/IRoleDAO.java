package edu.neu.coe.api.dao;

import java.util.List;

import edu.neu.coe.api.model.Role;
import edu.neu.coe.api.model.User;

public interface IRoleDAO {

	//CRUD
	public void create(Role role);
	
	public Role find(Integer id);
	public void update(Role role);
	public void delete(Integer id);
	public List<Role> getAll();
	public Role get(String name);
}
