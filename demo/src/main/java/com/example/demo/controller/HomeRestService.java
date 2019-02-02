package com.example.demo.controller;


import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestService {
	
	@RequestMapping(value="/home", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public String getHome() {
		return "home";
	}

}
