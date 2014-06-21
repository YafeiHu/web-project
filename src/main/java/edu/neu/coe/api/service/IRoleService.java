package edu.neu.coe.api.service;

import java.io.Serializable;
import java.util.List;

import edu.neu.coe.api.model.Role;
import edu.neu.coe.api.model.User;

public interface IRoleService extends IAbstractService<Role,Integer>{


	public Role find(String name);
}
