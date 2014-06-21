package edu.neu.coe;

import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.hibernate.annotations.Parameter;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.CityPhoto;
import edu.neu.coe.api.model.Continent;
import edu.neu.coe.api.model.Country;
import edu.neu.coe.api.model.CountryPhoto;
import edu.neu.coe.api.model.Role;
import edu.neu.coe.api.model.Photo;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.model.UserPhoto;
import edu.neu.coe.api.service.IRoleService;
import edu.neu.coe.api.service.IUserPhotoService;
import edu.neu.coe.api.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value="/success",method=RequestMethod.GET)
	public String success() {
		return "success";
	}
	@RequestMapping(value="/map",method=RequestMethod.GET)
	public String map() {
		return "map";
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String  get(Model model){
		model.addAttribute("user",new User());
		return "addUser";
	}
	
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public String add(@ModelAttribute("user")User user, BindingResult result,@RequestParam("file") MultipartFile file){
		try {
			UserPhoto p=new UserPhoto();
			p.setContent(file.getBytes());
			user.setPhoto(p);
			Role r=roleService.find(1);
			user.getRoles().add(r);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userService.create(user);
		return "homepage";
	}
	
	
	@RequestMapping(value="/{Id}",method=RequestMethod.GET)
	public String getUser(@PathVariable Integer Id,Model model){
		System.out.println(Id);
		User u=userService.find(Id);
		Set<Photo> photos=u.getPhotos();;
		model.addAttribute("photos", photos);
		System.out.println(photos.size());
		return "userPhotoList";
	}
	
	@RequestMapping(value="/userlist",method=RequestMethod.GET)
	public String  getAll(Model model){
		List<User> users=(List<User>) userService.getAll();
		model.addAttribute("users",users);
		return "userlist";
	}
	
	@RequestMapping(value="/{Id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable Integer Id) {
		userService.delete(Id);
		return "user";
	}
	
	@RequestMapping(value = "/updateuser*", method = RequestMethod.GET)
	public String getUser(Model model,@RequestParam("name") String name) {
		User user=userService.find(name);
		model.addAttribute("user", user);
		System.out.println("user"+user.getId());
		return "updateUser";
	}
	
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user,BindingResult result,@RequestParam("file") MultipartFile file) {
		UserPhoto p=new UserPhoto();
		try {
			p.setContent(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setPhoto(p);
		p.setOwner(user);
		System.out.println(user.getId());
		userService.update(user);
		return "homepage";
	}
	
}
