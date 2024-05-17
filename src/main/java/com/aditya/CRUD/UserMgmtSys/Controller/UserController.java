package com.aditya.CRUD.UserMgmtSys.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.CRUD.UserMgmtSys.ExceptionHandling.ValidationsWithExceptionHandling;
import com.aditya.CRUD.UserMgmtSys.Repository.UserRepository;
import com.aditya.CRUD.UserMgmtSys.UserdefinedExceptions.UserNotFoundException;
import com.aditya.CRUD.UserMgmtSys.Users.User;

import jakarta.validation.Valid;


@RestController
public class UserController {
	
	
	@Autowired
	ValidationsWithExceptionHandling exceptions;

	@Autowired
	UserRepository repo;
	
//	INSERT INTO users (`userid` , `confirm password`, `email id`, `first name`, `last name`, `password`, `phone number`) VALUES (1 , 'A@12', 'aditya@gmail.com', 'Aditya', 'Gupta', 'A@12', '999999');
	@GetMapping("/users") 
	public List<User> getUserlist(){
		
		List<User> userlist = repo.findAll();
		return userlist;
		
	}
	
	@GetMapping("/users/{userid}") 
	public User getUserById(@PathVariable int userid) throws UserNotFoundException{
		
		User user  = repo.findById(userid).get();
		
		List<User> list = new ArrayList<User>();
		for (User user2 : list) {
			if(user2.getUserid()==userid) {
				return user;
			}
			else throw new UserNotFoundException("user nout found by Id Input"  + "you're trying to enter");

		}
		
		return user;
		
		
		
	}
	

		
	
	//Post: For Multiple user  with response status as CREATED
	/*
	 * @PostMapping("/addusers") 
	 * public ResponseEntity<List<User>> addUsers(@Valid @RequestBody List<User> user){ 
	 * List <User> u = (List<User>)repo.saveAll(user); 
	 * return ResponseEntity.status(HttpStatus.CREATED).body(u);
	 * }
	 */
	
	
	//Post: For Single User with response status as CREATED
	/*
	 * @PostMapping("/addusers") public ResponseEntity<User> addUsers(@Valid @RequestBody
	 * User user){
	 * 
	 * User u = repo.save(user); return
	 * ResponseEntity.status(HttpStatus.CREATED).body(u);
	 * 
	 * }
	 */
	
	
	  @PostMapping("/addusers")
	  @ResponseStatus(code = HttpStatus.CREATED)
	  public void addUsers(@Valid @RequestBody User user) throws UserNotFoundException{ 
		  
		  
		  

		  if(user.getCon_password()==user.getPassword()) {
			  repo.save(user);  
		  }
		  else 
	    	  throw new UserNotFoundException("user nout found by the Dis dimilar Phone Number"  + "you're trying to enter");
		  
	  }
	  
	  //Without Response Stauts Created:
		/*
		 * @PostMapping("/addusers") public void addUsers(@RequestBody User user){
		 * 
		 * repo.save(user); }
		 */
	  
	  @PutMapping("/updateuser/{userid}")
	  public User updateUsers(@PathVariable int userid) {
		  User us = repo.findById(userid).get();
		  us.setCon_password("Vnn@10");
		  us.setPassword("Vnn@10");
		  us.setPhno(9822258774L);
		  return repo.save(us);
		  
	  }
	  
	  @DeleteMapping("/deleteuser/{userid}")
	  public String delete(@PathVariable int userid) {
		  repo.deleteById(userid);
		  return "Deleted Success";
	  }
	  
	  //Another Delete technique
		/*
		 * @DeleteMapping("/deleteuserr/{userid}") public void deletee(@PathVariable int
		 * userid) { User uu = repo.findById(userid).get(); repo.delete(uu); }
		 */
	  
	  
	  @GetMapping("/finduser/{firstname}")
	  public User findByFirstNamee(@PathVariable String firstname) throws  UserNotFoundException {
		 
	    	  User use =  repo.findByFirstname(firstname);
	    	  
		      if(use!=null) {
		    	  return use;
		      }
		      
		      else {
		    	  throw new UserNotFoundException("user nout found by the name : -> " + firstname + " <- you're trying to enter");
		      }
		      
	  }
	      
	  



}


	  
	  
	  
	  
	  
	  
	
	

