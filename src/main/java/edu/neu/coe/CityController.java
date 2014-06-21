package edu.neu.coe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotEmpty;
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
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.Photo;
import edu.neu.coe.api.model.UserPhoto;
import edu.neu.coe.api.service.ICityService;
import edu.neu.coe.api.service.IContinentService;
import edu.neu.coe.api.service.ICountryService;

@Controller
@RequestMapping("/city")
public class CityController {

	@Autowired
	private ICityService cityService;
	@Autowired
	private ICountryService countryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String get(Model model) {
		City city = new City();
		List<Country> countrys = (List<Country>) countryService.getAll();
		model.addAttribute("city", city);
		model.addAttribute("countrys", countrys);
		return "addCity";
	}
	
	@RequestMapping(value = "/addcity", method = RequestMethod.POST)
	public String add(@ModelAttribute("city") City city,
			BindingResult result, @RequestParam("country") String country,
			@RequestParam("file") MultipartFile file) {
		Country c= countryService.get(country);
		city.setCountry(c);
		CityPhoto p = new CityPhoto();
		try {
			p.setContent(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setCity(city);
		city.setCoverphoto(p.getId());
		cityService.create(city);
		return "addCity";
	}
	
	@RequestMapping(value="/{Id}",method=RequestMethod.GET)
	public String find(@PathVariable Integer Id,Model model){
		City city=cityService.find(Id);
		List<CityPhoto> photos=new ArrayList<CityPhoto>();
		if(city.getPhotos().size()>0){
		for(CityPhoto c:city.getPhotos()){
			photos.add(c);
		}
		city.setCoverphoto(photos.get(0).getId());
		}
		Set<Sight> sights=city.getSights();
		Set<Food> foods=city.getFoods();
		model.addAttribute("city", city);
		model.addAttribute("foods", foods);
		model.addAttribute("sights", sights);
		return "city";
	}
	
	@RequestMapping(value="/citylist",method=RequestMethod.GET)
	public String getAll(Model model){
		List<City> citys=(List<City>)cityService.getAll();
		model.addAttribute("citys", citys);
		return "country";
	}
	
	@RequestMapping(value="/{Id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable Integer Id) {
		cityService.delete(Id);
		return "";
	}
	
	@RequestMapping(value="/getcity", method=RequestMethod.POST)
	public String getCity(@RequestParam("name")String name,Model model) {
		for(City city:cityService.getAll()){
			if(city.getCityname().equals(name)){
				Set<Sight> sights=city.getSights();
				Set<Food> foods=city.getFoods();
				model.addAttribute("city", city);
				model.addAttribute("foods", foods);
				model.addAttribute("sights", sights);
				return "city";
			}
		}
		return "";
	}
	
	@RequestMapping(value="{Id}/sight",method=RequestMethod.GET)
	public String sightlist(@PathVariable Integer Id,Model model){
		City city=cityService.find(Id);
		Set<Sight> sights=new HashSet<Sight>();
				for(Sight s:city.getSights()){
					sights.add(s);
		}
		model.addAttribute("city", city);
		model.addAttribute("sights", sights);
		return "sightlist";
	}
	
	@RequestMapping(value="{Id}/food",method=RequestMethod.GET)
	public String foodlist(@PathVariable Integer Id,Model model){
		City city=cityService.find(Id);
		Set<Food> foods=new HashSet<Food>();
				for(Food f:city.getFoods()){
					foods.add(f);
		}
		model.addAttribute("city", city);
		model.addAttribute("foods", foods);
		return "foodlist";
	}
	
	@RequestMapping(value="{Id}/photo",method=RequestMethod.GET)
	public String photolist(@PathVariable Integer Id,Model model){
		City city=cityService.find(Id);
		Set<CityPhoto> photos=city.getPhotos();
		model.addAttribute("foods", photos);
		return "photolist";
	}
	
	
	@RequestMapping(value = "{Id}/updatecity", method = RequestMethod.GET)
	public String getCity(@PathVariable Integer Id,Model model) {
		City city=cityService.find(Id);
		model.addAttribute("city", city);
		return "updateCity";
	}
	
	@RequestMapping(value = "{Id}/updatecity", method = RequestMethod.POST)
	public @ResponseBody String updateCity(@ModelAttribute("city") City city,BindingResult result,@RequestParam("country") String country) {
		Country c=countryService.get(country);
		city.setCountry(c);
		cityService.update(city);
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
		City city=cityService.find(Id);
		CityPhoto p=new CityPhoto();
		p.setContent(file.getBytes());
		p.setCity(city);
		city.getPhotos().add(p);
		cityService.update(city);
		System.out.println(p.getId());
		return "";
	}
}
