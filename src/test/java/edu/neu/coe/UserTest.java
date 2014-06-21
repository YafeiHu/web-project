package edu.neu.coe;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Country;
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.FoodPhoto;
import edu.neu.coe.api.model.FoodRating;
import edu.neu.coe.api.model.Role;
import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.User;

public class UserTest {

	public static void main(String args[]){
	Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
	SessionFactory sf=cfg.buildSessionFactory();
	Session session=sf.openSession();
	session.beginTransaction();
	
	/*User u1=new User();
	u1.setName("yafei");
	u1.setPassword("1");
	u1.setEmail("1");*/
	
	
	/*Country c=new Country();
	c.setCountryname("ccc");
	City ci=new City();
	ci.setCityname("c1");
	ci.setCountry(c);*/
	
	
	/*Country c=new Country();
	c.setCountryname("country4");
	City ci=new City();
	ci.setCityname("city4");
	ci.setCountry(c);
	Food f=new Food();
	f.setFoodname("food4");
	f.setCity(ci);
	Sight s=new Sight();
	s.setSightname("sight4");
	s.setCity(ci);
	ci.getFoods().add(f);
	ci.getSights().add(s);*/
	
	/*FoodCategory fc1=new FoodCategory();
	fc1.setCategoryName("FoodCategory1");
	SightCategory sc1=new SightCategory();
	sc1.setCategoryName("SightCategory1");
	
	/*FoodCategory fc2=new FoodCategory();
	fc2.setCategoryName("FoodCategory2");
	SightCategory sc2=new SightCategory();
	sc2.setCategoryname("SightCategory2");*/
	
	/*fc1.getFoods().add(f);
	sc1.getSights().add(s);
	f.getCategorys().add(fc1);
	s.getCategorys().add(sc1);
	/*fc2.getFoods().add(f);
	sc2.getSights().add(s);
	f.getCategorys().add(fc2);
	s.getCategorys().add(sc2);*/
	
	
	
	/*session.saveOrUpdate(c);
	session.saveOrUpdate(ci);
	session.saveOrUpdate(f);
	session.saveOrUpdate(s);
	session.saveOrUpdate(fc1);
	session.saveOrUpdate(sc1);
	/*session.saveOrUpdate(fc2);
	session.saveOrUpdate(sc2);*/
	
	User u1=new User();
	u1.setName("user1");
	u1.setPassword("1");
	u1.setEmail("user1");
	
	/*FoodRating fr1=new FoodRating();
	fr1.setContent("content1");
	fr1.setDate(new Date());
	fr1.setRating(3);
	fr1.setUser(u1);
	fr1.setFood(f);
	f.getFood_ratings().add(fr1);
	u1.getFood_ratings().add(fr1);*/
	
	Role r1=new Role();
	r1.setRolename("USER");
	u1.getRoles().add(r1);
	
	Role r2=new Role();
	r2.setRolename("ADMIN");
	u1.getRoles().add(r2);
	
	//WorkRequest wr1=new WorkRequest();
	//wr1.setSender(u1);
	//wr1.setRequestDate(new Date());
	//wr1.setStatus("not done");
	//u1.getRequests().add(wr1);
	//r1.getRequests().add(wr1);
	
	session.saveOrUpdate(u1);
	//session.saveOrUpdate(r2);
	//session.saveOrUpdate(r1);
	//session.saveOrUpdate(wr1);
	//session.saveOrUpdate(f);
	session.getTransaction().commit();
	session.close();
	sf.close();
	}
}
