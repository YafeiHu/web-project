package edu.neu.coe.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.api.dao.ISightRatingDAO;
import edu.neu.coe.api.dao.IUserDAO;
import edu.neu.coe.api.model.SightRating;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.service.ISightRatingService;
import edu.neu.coe.api.service.IUserService;
@Service("sightRatingService")
@Transactional(readOnly = true)
public class SightRatingService implements ISightRatingService{

	@Autowired
	private ISightRatingDAO SightRatingDAO;

	@Override
	@Transactional(readOnly = false)
	public void create(SightRating user) {
		SightRatingDAO.create(user);
	}

	/*@Override
	@Transactional(readOnly = false)
	public User find(String username, String password) {
		for(User user:SightRatingDAO.getAllUser()){
			if(user.getName().equals(username)&&user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}*/

	@Override
	@Transactional(readOnly = false)
	public List<SightRating> getAll() {
		return SightRatingDAO.getAll();
	}

	@Override
	@Transactional
	public void update(SightRating e) {
		SightRatingDAO.update(e);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		SightRatingDAO.delete(id);
		
	}

	@Override
	@Transactional
	public SightRating find(Integer id) {
		return SightRatingDAO.find(id);
	}

	

}
