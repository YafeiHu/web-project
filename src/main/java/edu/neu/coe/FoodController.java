package edu.neu.coe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.FoodPhoto;
import edu.neu.coe.api.model.FoodRating;
import edu.neu.coe.api.model.Role;
import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.service.ICityService;
import edu.neu.coe.api.service.IFoodRatingService;
import edu.neu.coe.api.service.IFoodService;
import edu.neu.coe.api.service.IRoleService;
import edu.neu.coe.api.service.IUserService;

@Controller
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private IFoodService foodService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ICityService cityService;
	@Autowired
	private IFoodRatingService foodRatingService;
	
	@RequestMapping(value="/{Id}",method=RequestMethod.GET)
	public String find(@PathVariable Integer Id,Model model){
		Food food=foodService.find(Id);
		Set<FoodRating> foodRatings=food.getFood_ratings();
		FoodRating foodRating=new FoodRating();
		model.addAttribute("food", food);
		model.addAttribute("foodRatings", foodRatings);
		model.addAttribute("foodRating", foodRating);
		return "foodDetail";
	}
	
	@RequestMapping(value="/{Id}/addrating",method=RequestMethod.POST)
	public @ResponseBody String addRating(@ModelAttribute("foodRating")FoodRating foodRating, BindingResult result,@PathVariable Integer Id,@RequestParam("user") String user,Model model){
		User u=userService.find(user);
		Food food=foodService.find(Id);
		foodRating.setUser(u);
		foodRating.setFood(food);;
		foodRating.setDate(new Date());
		food.getFood_ratings().add(foodRating);
		foodRatingService.create(foodRating);
		return "";
	}
	
	@RequestMapping(value="{id}/foodlist",method=RequestMethod.GET)
	public String getAll(@PathVariable Integer id){
		List<Food> foods=new ArrayList<Food>();
		for(Food food:foodService.getAll()){
			if(food.getCity().getId()==id){
				foods.add(food);
			}
		}
		return "foodlist";
	}

	
	@RequestMapping(value="/{Id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable Integer Id) {
		foodService.delete(Id);
		return "";
	}
	
	@RequestMapping(value = "{Id}/updatefood", method = RequestMethod.GET)
	public String getFood(@PathVariable Integer Id,Model model) {
		Food food=foodService.find(Id);
		model.addAttribute("food", food);
		return "updateFood";
	}
	
	@RequestMapping(value = "{Id}/updatefood", method = RequestMethod.POST)
	public @ResponseBody String updateFood(@ModelAttribute("food") Food food,BindingResult result,@RequestParam("city") String city) {
		Integer id=Integer.valueOf(city);
		City c=cityService.find(id);
		food.setCity(c);
		foodService.update(food);
		return "";
	}
	
	@RequestMapping(value = "/addfood", method = RequestMethod.GET)
	public String getFood(Model model) {
		Food food=new Food();
		model.addAttribute("food", food);
		return "addFood";
	}
	@RequestMapping(value="/addfood",method=RequestMethod.POST)
	public @ResponseBody String add(@ModelAttribute("food") Food food,BindingResult result,@RequestParam("city") String city){
		City c=cityService.get(city);
		food.setCity(c);
		foodService.create(food);
		return "";
	}
	@RequestMapping(value = "{Id}/addphoto", method = RequestMethod.GET)
	public String getphoto(@PathVariable Integer Id,Model model) {
		City city=cityService.find(Id);
		model.addAttribute("city", city);
		return "uploadPhoto";
	}
	
	@RequestMapping(value = "{Id}/addphoto", method = RequestMethod.POST)
	public @ResponseBody String addphoto(@PathVariable Integer Id,@RequestParam("file") MultipartFile file) throws IOException {
		Food food=foodService.find(Id);
		FoodPhoto p=new FoodPhoto();
		p.setContent(file.getBytes());
		p.setFood(food);;
		food.getPhotos().add(p);
		foodService.update(food);
		System.out.println(p.getId());
		return "";
	}
	
	
}
