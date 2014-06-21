package edu.neu.coe.api.dao;

import java.util.List;

import edu.neu.coe.api.model.User;

public interface IUserDAO {

	//CRUD
	public void create(User user);
	public User find(Integer id);
	public void update(User user);
	public void delete(Integer id);
	public List<User> getAll();
	public User get(String name);
}
