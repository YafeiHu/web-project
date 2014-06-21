package edu.neu.coe.api.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.api.dao.IUserDAO;
import edu.neu.coe.api.model.Role;


	@Service("CustomerUserDetailService") 
	@Transactional(readOnly=true)  
	public class CustomerUserDetailService implements UserDetailsService {  
	      
		@Autowired
		private IUserDAO userDAO;     
	  
	    public UserDetails loadUserByUsername(String name)  
	            throws UsernameNotFoundException {  
	    //	System.out.println("ccc"+name);
	    	edu.neu.coe.api.model.User domainUser = userDAO.get(name); 
	    //	System.out.println("ddd"+userDAO.find(1).getName());
	    //	System.out.println(domainUser.getPassword());
	        UserDetails user=null;
	        boolean enabled = true;  
	        boolean accountNonExpired = true;  
	        boolean credentialsNonExpired = true;  
	        boolean accountNonLocked = true;  
	        if(domainUser!=null){
	        	 user=new User(  
	 	                domainUser.getName(),   
	 	                domainUser.getPassword(),   
	 	                enabled,   
	 	                accountNonExpired,   
	 	                credentialsNonExpired,   
	 	                accountNonLocked,  
	 	                getUserAuthorities(domainUser)  
	 	        );  
	        }
	        return user;
	       
	    }  
	    
	    @SuppressWarnings("deprecation")
		public Collection<GrantedAuthority> getUserAuthorities(edu.neu.coe.api.model.User user){  
	        Set<GrantedAuthority> autthorities = new HashSet<GrantedAuthority>();  
	        Set<Role> roles =  user.getRoles();  
	        for (Role role : roles) {  
	            autthorities.add(new GrantedAuthorityImpl(role.getRolename()));  
	        }  
	        return autthorities ;  
	    }
	}    
	   
