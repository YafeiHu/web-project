package edu.neu.coe.api.dao;

import java.util.ArrayList;
import java.util.List;

import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Reply;
import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.Photo;
import edu.neu.coe.api.model.Topic;


public interface IReplyDAO {

	public void create(Reply city);
	public Reply find(Integer id);
	public void update(Reply city);
	public void delete(Integer id);
	public List<Reply> getAll();
	
}
