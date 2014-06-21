 package edu.neu.coe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.CityPhoto;
import edu.neu.coe.api.model.Continent;
import edu.neu.coe.api.model.Country;
import edu.neu.coe.api.model.CountryPhoto;
import edu.neu.coe.api.model.Food;
import edu.neu.coe.api.model.Role;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.service.ICityService;
import edu.neu.coe.api.service.IContinentService;
import edu.neu.coe.api.service.ICountryService;
import edu.neu.coe.api.service.IFoodService;
import edu.neu.coe.api.service.IRoleService;
import edu.neu.coe.api.service.IUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IFoodService foodService;
	@Autowired
	private ICityService cityService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IContinentService continentService;
	
	@RequestMapping(value="/addcontinent",method=RequestMethod.GET)
	public String get(Model model){
		Continent continent=new Continent();
		List<Continent> continents=(List<Continent>)continentService.getAll();
		model.addAttribute("continents", continents);
		model.addAttribute("continent", continent);
		return "addContinent";
	}
	
	@RequestMapping(value="/addcontinent",method=RequestMethod.POST)
	public String add(@ModelAttribute("continent")Continent continent, BindingResult result){
		continentService.create(continent);
		return "addContinent";
	}
	
	
	
	
	
	
	
	
	

}
