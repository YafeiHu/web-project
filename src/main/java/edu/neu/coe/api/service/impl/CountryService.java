package edu.neu.coe.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.api.dao.ICountryDAO;
import edu.neu.coe.api.dao.IUserDAO;
import edu.neu.coe.api.model.Continent;
import edu.neu.coe.api.model.Country;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.service.ICountryService;
import edu.neu.coe.api.service.IUserService;
@Service("countryService")
@Transactional(readOnly = true)
public class CountryService implements ICountryService{

	@Autowired
	private ICountryDAO countryDAO;

	@Override
	@Transactional(readOnly = false)
	public void create(Country user) {
		countryDAO.create(user);
	}

	@Override
	@Transactional
	public Country get(String name) {
		for(Country user:countryDAO.getAll()){
			System.out.println(user.getCountryname());
			if(user.getCountryname().equals(name)){
				return user;
			}
		}
		return null;
	}
	

	@Override
	@Transactional(readOnly = false)
	public List<Country> getAll() {
		return countryDAO.getAll();
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Country e) {
		countryDAO.update(e);
		
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id) {
		countryDAO.delete(id);
		
	}

	@Override
	@Transactional
	public Country find(Integer id) {
		return countryDAO.find(id);
	}

	

}
