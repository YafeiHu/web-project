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
import edu.neu.coe.api.model.FoodRating;
import edu.neu.coe.api.model.Role;
import edu.neu.coe.api.model.Sight;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.service.ICityService;
import edu.neu.coe.api.service.IFoodService;
import edu.neu.coe.api.service.IRoleService;
import edu.neu.coe.api.service.IUserService;
/*
@Controller
@RequestMapping("/request")
public class RequestController {

	@Autowired
	private IWorkRequestService workRequestService;
	@Autowired
	private IFoodService foodService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model){
		List<WorkRequest> requests=workRequestService.getAll();
		model.addAttribute("requests", requests);
		return "requestFood";
	}
	
	@RequestMapping(value="/{Id}/approve",method=RequestMethod.GET)
	public String approve(@PathVariable Integer Id,Model model){
		WorkRequest w=workRequestService.find(Id);
		Food fc=w.getFood();
		foodService.update(fc);
		w.setStatus("approved");
		w.setFinishDate(new Date());
		return "foodDetail";
	}
	
}*/
