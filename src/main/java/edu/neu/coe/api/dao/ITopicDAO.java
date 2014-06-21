package edu.neu.coe.api.dao;

import java.util.ArrayList;
import java.util.List;

import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.Photo;
import edu.neu.coe.api.model.Topic;


public interface ITopicDAO {

	public void create(Topic city);
	public Topic find(Integer id);
	public void update(Topic city);
	public void delete(Integer id);
	public List<Topic> getAll();
	
}
