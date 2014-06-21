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
import edu.neu.coe.api.model.CityPhoto;
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
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private ICountryService countryService;
	@Autowired
	private IContinentService continentService;

	/*
	 * @RequestMapping(value="/addcountry",method=RequestMethod.POST) public
	 * String add(@RequestParam("countryname")String countryname){ Country
	 * country=new Country(); country.setCountryname(countryname);
	 * countryService.create(country); return "country"; }
	 */

	
	@RequestMapping(value = "/{countryId}", method = RequestMethod.GET)
	public String find(@PathVariable Integer countryId, Model model) {
		Country country = countryService.find(countryId);
		Set<City> citys = country.getCitys();
		for(City c:citys){
			if(c.getPhotos().size()>0){
			List<CityPhoto> photos=new ArrayList<CityPhoto>();
			for(CityPhoto cp:c.getPhotos()){
				photos.add(cp);
			}
			c.setCoverphoto(photos.get(0).getId());}
		}
		model.addAttribute("country", country);
		model.addAttribute("citys", citys);
		return "country";
	}

	@RequestMapping(value = "/countrylist", method = RequestMethod.GET)
	public String List(Model model) {
		List<Country> countrys = (List<Country>) countryService.getAll();
		model.addAttribute("countrys", countrys);
		return "countrylist";
	}


	@RequestMapping(value = "/{Id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer Id) {
		countryService.delete(Id);
		return "";
	}

	@RequestMapping(value = "/getCountry", method = RequestMethod.POST)
	public String getCountry(@RequestParam("name") String name, Model model) {
		for (Country country : countryService.getAll()) {
			if (country.getCountryname().equals(name)) {
				model.addAttribute("country", country);
				Set<City> citys = country.getCitys();
				model.addAttribute("country", country);
				model.addAttribute("citys", citys);
				return "country";
			}
		}
		return "";
	}

	@RequestMapping(value = "{Id}/sight", method = RequestMethod.GET)
	public String sightlist(@PathVariable Integer Id, Model model) {
		Country country = countryService.find(Id);
		Set<Sight> sights = new HashSet<Sight>();
		for (City c : country.getCitys()) {
			for (Sight s : c.getSights()) {
				sights.add(s);
			}
		}
		model.addAttribute("country", country);
		model.addAttribute("sights", sights);
		return "sightlist";
	}

	@RequestMapping(value = "{Id}/food", method = RequestMethod.GET)
	public String foodlist(@PathVariable Integer Id, Model model) {
		Country country = countryService.find(Id);
		Set<Food> foods = new HashSet<Food>();
		for (City city : country.getCitys()) {
			for (Food f : city.getFoods()) {
				foods.add(f);
			}
		}
		model.addAttribute("country", country);
		model.addAttribute("foods", foods);
		return "foodlist";
	}
	
	@RequestMapping(value = "/addcountry", method = RequestMethod.POST)
	public @ResponseBody String add(@ModelAttribute("country") Country country,
			BindingResult result, @RequestParam("continent") String continent,@RequestParam("file") MultipartFile file) {
		Continent c = continentService.get(continent);
		country.setContinent(c);
		CountryPhoto p = new CountryPhoto();
		try {
			p.setContent(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		country.setPhoto(p);
		countryService.create(country);
		return "";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model) {
		Country country = new Country();
		List<Country> countrys = (List<Country>) countryService.getAll();
		model.addAttribute("country", country);
		model.addAttribute("countrys", countrys);
		return "addCountry";
	}
	
	@RequestMapping(value = "{Id}/updatecountry", method = RequestMethod.GET)
	public String getCountry(@PathVariable Integer Id,Model model) {
		Country country=countryService.find(Id);
		model.addAttribute("country", country);
		return "updateCountry";
	}
	
	@RequestMapping(value = "{Id}/updatecountry", method = RequestMethod.POST)
	public @ResponseBody String updateCountry(@ModelAttribute("country") Country country,BindingResult result,@RequestParam("continent") String continent,@RequestParam("file") MultipartFile file) throws IOException {
		Continent c=continentService.get(continent);
		country.setContinent(c);
		if(file.getBytes().length>0){
		CountryPhoto p=new CountryPhoto();
		p.setContent(file.getBytes());
		country.setPhoto(p);
		p.setCountry(country);
		}
		countryService.update(country);
		return "";
	}
}
