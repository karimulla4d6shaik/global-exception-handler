package com.exception.service;

import org.springframework.stereotype.Service;

@Service
public class GlobalService {

	public String sayHello(String name) {
		//You had some business logic ok, this business logic got failed due to Null Pointer Exception.
				if(true) {
					throw new NullPointerException("Null value");
				}				
				return "Hello "+name;
	}
}
