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

import edu.neu.coe.api.model.Photo;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.service.IUserPhotoService;
import edu.neu.coe.api.service.IUserService;

@Controller
@RequestMapping("/photo")
public class PhotoController {

	@Autowired
	private IUserPhotoService userPhotoService;
	
	
	@RequestMapping(value="/{Id}",method=RequestMethod.GET)
	public @ResponseBody String viewPhoto(@PathVariable Integer Id, HttpServletResponse response) throws IOException {
		Photo photo = userPhotoService.find(Id);
    	byte[] photoBytes = photo.getContent();
    	if (photoBytes != null) {
	    	int length = photoBytes.length;
	    	ServletOutputStream op = response.getOutputStream();
	        
	    	response.setContentType("image/jpeg");
	    	response.setContentLength(length);
	    	response.setHeader("Content-Disposition",
	    			"attachment; filename=\"photo_" + photo.getId() + ".jpg\"");
	
	    	op.write(photoBytes, 0, length);
	    	op.flush();
	    	op.close();
    	}
 
        return "";
	}
}
