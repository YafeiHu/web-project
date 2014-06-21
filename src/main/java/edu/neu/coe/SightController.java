package edu.neu.coe;

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

import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.FoodRating;
import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.SightRating;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.service.ICityService;
import edu.neu.coe.api.service.IFoodService;
import edu.neu.coe.api.service.ISightRatingService;
import edu.neu.coe.api.service.ISightService;
import edu.neu.coe.api.service.IUserService;

@Controller
@RequestMapping("/sight")
public class SightController {

	@Autowired
	private ISightService sightService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ISightRatingService sightRatingService;
	
	@RequestMapping(value="/addsight ",method=RequestMethod.POST)
	public String add(@RequestParam("name")String name){
		Sight sight=new Sight();
		sight.setSightname(name);
		sightService.create(sight);
		return "dashboard";
	}
	
	@RequestMapping(value="/{Id}",method=RequestMethod.GET)
	public String find(@PathVariable Integer Id,Model model){
		Sight sight=sightService.find(Id);
		Set<SightRating> sightRatings=sight.getSight_ratings();
		SightRating sightRating=new SightRating();
		model.addAttribute("sight", sight);
		model.addAttribute("sightCategorys", sightRatings);
		model.addAttribute("sightRating", sightRating);
		return "sightDetail";
	}
	
	@RequestMapping(value="/{Id}/addrating",method=RequestMethod.POST)
	public String addRating(@ModelAttribute("sightRating")SightRating sightRating, BindingResult result,@PathVariable Integer Id,@RequestParam("user") String user,Model model){
		User u=userService.find(user);
		Sight sight=sightService.find(Id);
		sightRating.setUser(u);
		sightRating.setSight(sight);
		sightRating.setDate(new Date());
		sight.getSight_ratings().add(sightRating);
		sightRatingService.create(sightRating);
		return "sightDetail";
	}
	
	@RequestMapping(value="{id}/sightlist",method=RequestMethod.GET)
	public String getAll(@PathVariable Integer id){
		List<Sight> sights=new ArrayList<Sight>();
		for(Sight sight:sightService.getAll()){
			if(sight.getCity().getId()==id){
				sights.add(sight);
			}
		}
		return "sightlist";
	}
	
	@RequestMapping(value="/{Id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable Integer Id) {
		sightService.delete(Id);
		return "";
	}
	
}
