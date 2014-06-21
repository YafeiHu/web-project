package edu.neu.coe.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.api.dao.ICityDAO;
import edu.neu.coe.api.dao.IContinentDAO;
import edu.neu.coe.api.dao.IUserDAO;
import edu.neu.coe.api.dao.IPhotoDAO;
import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Continent;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.model.Photo;
import edu.neu.coe.api.service.ICityService;
import edu.neu.coe.api.service.IContinentService;
import edu.neu.coe.api.service.IUserPhotoService;
import edu.neu.coe.api.service.IUserService;
@Service("continentService")
@Transactional(readOnly = true)
public class ContinentService implements IContinentService{

	@Autowired
	private IContinentDAO DAO;

	@Override
	@Transactional(readOnly = false)
	public void create(Continent user) {
		DAO.create(user);
	}

	/*@Override
	@Transactional(readOnly = false)
	public City find(String name) {
		for(City city:cityDAO.getAll()){
			if(city.getCityname().equals(name)){
				return city;
			}
		}
		return null;
	}*/

	@Override
	@Transactional(readOnly = false)
	public List<Continent> getAll(){
		return DAO.getAll();
	}

	@Override
	@Transactional
	public void update(Continent e) {
		DAO.update(e);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		DAO.delete(id);
		
	}

	@Override
	@Transactional
	public Continent find(Integer id) {
		return DAO.find(id);
	}

	@Override
	@Transactional
	public Continent get(String name){
		for(Continent c:DAO.getAll()){
			if(c.getName().equals(name)){
				return c;
			}
		}
		return null;
	}
	

}
