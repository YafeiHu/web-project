package edu.neu.coe.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.api.dao.ICityDAO;
import edu.neu.coe.api.dao.IUserDAO;
import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.service.ICityService;
import edu.neu.coe.api.service.IUserService;
@Service("cityService")
@Transactional(readOnly = true)
public class CityService implements ICityService{

	@Autowired
	private ICityDAO cityDAO;

	@Override
	@Transactional(readOnly = false)
	public void create(City user) {
		cityDAO.create(user);
	}

	@Override
	@Transactional
	public City get(String name) {
		for(City city:cityDAO.getAll()){
			if(city.getCityname().equals(name)){
				return city;
			}
		}
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public List<City> getAll(){
		return cityDAO.getAll();
	}

	@Override
	@Transactional
	public void update(City e) {
		cityDAO.update(e);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		cityDAO.delete(id);
		
	}

	@Override
	@Transactional
	public City find(Integer id) {
		return cityDAO.find(id);
	}


	

}
