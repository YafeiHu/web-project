package edu.neu.coe.api.service;

import java.io.Serializable;
import java.util.List;

import edu.neu.coe.api.model.User;

public interface IUserService extends IAbstractService<User,Integer>{

	public User find(String name);
	public List<User> getAll();
}
