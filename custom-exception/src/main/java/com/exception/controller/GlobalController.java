package com.exception.controller;

import javax.naming.ServiceUnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.error.UserNotFoundException;
import com.exception.service.GlobalService;

@RestController
@RequestMapping(value = "/exception-handler")
public class GlobalController {
	
	@Autowired
	private GlobalService service;

	@GetMapping("/{name}")
	public String sayHello(@PathVariable String name) {
		return service.sayHello(name);
	}
	
	@GetMapping
	public void sayHello1() {
		throw new NullPointerException("ASDFGHJKL");
	}
	
	@PostMapping
	public void sayHello2() throws ServiceUnavailableException {
		//Here we are calling some 3rd party api and it is down.
		throw new ServiceUnavailableException("Role service not available...");
	}
	
	@PutMapping
	public void sayHello3(){
		try {
			//Here we are calling some 3rd party api(Employee service) and it is having some problem and it is throwing some exception.
			//we are assuming that exception as User not found with employee id Problem
			throw new Exception("User not found with employee id : 123456");
		}catch(Exception e) {
			throw new UserNotFoundException(e.getMessage(), e);
		}
	}
	
	@DeleteMapping
	public void sayHello4(){
		//Here we are calling some 3rd party api(Employee service) and it is having some problem and it is throwing some exception.
		//we are assuming that exception as User not found with employee id Problem
		throw new UserNotFoundException("User not found with employee id : 123456");	
	}
	
	@PatchMapping
	public void sayHello5() throws Exception{
		//Here we are calling some 3rd party api(Employee service) and it is having some problem and it is throwing some exception.
		//we are assuming that exception as User not found with employee id Problem
		throw new Exception("User not found with employee id : 123456");	
	}
}
