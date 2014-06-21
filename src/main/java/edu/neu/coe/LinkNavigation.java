package edu.neu.coe;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.neu.coe.api.model.User;

@Controller
@RequestMapping("/login")
public class LinkNavigation {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String userlogin() {
		return "login";
	}
	

	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String redirectPage(HttpServletRequest request) {
		if (request.isUserInRole("ADMIN")) {
            return "admin";
        }
		else return "home";
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String AdminPage() {
		return "admin";
	}
	
	@RequestMapping(value="/superadmin", method=RequestMethod.GET)
	public String SuperAdminPage() {
		return "superadmin";
	}
	

}
