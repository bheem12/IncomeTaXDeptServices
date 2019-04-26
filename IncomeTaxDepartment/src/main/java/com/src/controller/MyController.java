package com.src.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.src.model.TdsMaster;
import com.src.service.IncomeTaxService;
import com.src.utility.IDNotFoundException;


@RestController    //combination of controller and requestbody
public class MyController {

	
	@Autowired     //used for dependency injection
	IncomeTaxService incomeTaxService;
	
	@GetMapping("/getById")    //method for retreiving the data by id
	public TdsMaster getByPid(@RequestBody int id) throws IDNotFoundException {
		
		TdsMaster t = incomeTaxService.getById(id);
		if(t==null) {
			throw new IDNotFoundException("ID not found Wrong ID:  "+id);
		}
		else
			return t;
		
	}

	
	
}
