package edu.neu.coe.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.api.dao.ICityDAO;
import edu.neu.coe.api.dao.IReplyDAO;
import edu.neu.coe.api.dao.ITopicDAO;
import edu.neu.coe.api.dao.IUserDAO;
import edu.neu.coe.api.dao.IPhotoDAO;
import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Reply;
import edu.neu.coe.api.model.Topic;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.model.Photo;
import edu.neu.coe.api.service.ICityService;
import edu.neu.coe.api.service.IReplyService;
import edu.neu.coe.api.service.ITopicService;
import edu.neu.coe.api.service.IUserPhotoService;
import edu.neu.coe.api.service.IUserService;
@Service("replyService")
@Transactional(readOnly = true)
public class ReplyService implements IReplyService{

	@Autowired
	private IReplyDAO cityDAO;

	@Override
	@Transactional(readOnly = false)
	public void create(Reply user) {
		cityDAO.create(user);
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
	public List<Reply> getAll(){
		return cityDAO.getAll();
	}

	@Override
	@Transactional
	public void update(Reply e) {
		cityDAO.update(e);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		cityDAO.delete(id);
		
	}

	@Override
	@Transactional
	public Reply find(Integer id) {
		return cityDAO.find(id);
	}


	

}
