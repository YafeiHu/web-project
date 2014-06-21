package edu.neu.coe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
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
import edu.neu.coe.api.model.Continent;
import edu.neu.coe.api.model.Country;
import edu.neu.coe.api.model.CountryPhoto;
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.model.Photo;
import edu.neu.coe.api.service.IContinentService;
import edu.neu.coe.api.service.ICountryService;
import edu.neu.coe.api.service.IUserService;

@Controller
@RequestMapping("/continent")
public class ContinentController {

	@Autowired
	private IContinentService continentService;
	
	/*
	@RequestMapping(value="/addcontinent",method=RequestMethod.POST)
	public String add(@RequestParam("name")String name){
		Continent country=new Continent();
		country.setName(name);
		continentService.create(country);
		return "editContinent";
	}*/
	
	
	
	
	@RequestMapping(value="/continentlist",method=RequestMethod.GET)
	public String getAll(Model model){
		List<Continent> continents=(List<Continent>)continentService.getAll();
		model.addAttribute("continents", continents);
		return "homepage";
	}
	
	
	
	@RequestMapping(value="/{Id}",method=RequestMethod.GET)
	public String find(@PathVariable Integer Id,Model model){
		Continent continent=continentService.find(Id);
		Set<Country> countrys=continent.getCountrys();
		model.addAttribute("continent", continent);
		model.addAttribute("countrys", countrys);
		return "continent";
	}
	
	@RequestMapping(value="/{Id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable Integer Id) {
		continentService.delete(Id);
		return "";
	}
	
	@RequestMapping(value="{Id}/food",method=RequestMethod.GET)
	public String foodlist(@PathVariable Integer Id,Model model){
		Continent continent=continentService.find(Id);
		Set<Food> foods=new HashSet<Food>();
		for(Country c:continent.getCountrys()){
			for(City city:c.getCitys()){
				for(Food f:city.getFoods()){
					foods.add(f);
				}
			}
		}
		model.addAttribute("continent", continent);
		model.addAttribute("foods", foods);
		return "foodlist";
	}
	
	@RequestMapping(value="{Id}/sight",method=RequestMethod.GET)
	public String sightlist(@PathVariable Integer Id,Model model){
		Continent continent=continentService.find(Id);
		Set<Sight> sights=new HashSet<Sight>();
		for(Country c:continent.getCountrys()){
			for(City city:c.getCitys()){
				for(Sight s:city.getSights()){
					sights.add(s);
				}
			}
		}
		model.addAttribute("continent", continent);
		model.addAttribute("sights", sights);
		return "sightlist";
	}
}
