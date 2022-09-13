package com.assignment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.service.EmpService;

@RestController
public class Controller {
	// DI
	@Autowired
	private EmpService sr;

	// CALLING THE POST METHOD TO SAVE THE RECORDS IN THE EMPLOYEE TABLE USINMG
	// SWAGGER
	@RequestMapping(value = "/csv/add", method = RequestMethod.POST)
	public void setDataInDb() {
		sr.saveData();
	}

}
