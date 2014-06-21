package edu.neu.coe.api.dao;

import java.util.ArrayList;
import java.util.List;

import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.Photo;


public interface IPhotoDAO {

	public void create(Photo city);
	public Photo find(Integer id);
	public void update(Photo city);
	public void delete(Integer id);
	public List<Photo> getAll();
	
}
