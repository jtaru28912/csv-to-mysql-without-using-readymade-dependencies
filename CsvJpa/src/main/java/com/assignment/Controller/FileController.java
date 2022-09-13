package com.assignment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.service.FileService;

@RestController
public class FileController {
	// DI
	@Autowired
	FileService fs;

	// CALLING GET METHOD VIA SWAGGER
	@RequestMapping(value = "/file/checkDupluicate", method = RequestMethod.GET)
	public ResponseEntity<String> checkduplicate() {

		// checking if the file is duplicate or not
		if (fs.checkduplicate() == true) {

			// if file is duplicate..
			return new ResponseEntity<String>("DUPLICATE FILE!! ", HttpStatus.BAD_REQUEST);
		} else {

			// if file is not duplicate then...
			return new ResponseEntity<String>("FILE SAVED SUCCESSFULLY!!", HttpStatus.OK);
		}
	}

	// CALLING GET METHOD VIA SWAGGER
	@RequestMapping(value = "/file/isValid", method = RequestMethod.GET)
	public ResponseEntity<String> isValid() {

		// checking if the file size is valid or not ..
		if (fs.isValid() == true) {

			// if file size is valid..
			return new ResponseEntity<String>("VALID FILE SIZE", HttpStatus.OK);
		}

		// else show this in the output..
		return new ResponseEntity<String>("INVALID FILE SIZE ", HttpStatus.BAD_REQUEST);
	}

	// CALLING GET METHOD VIA SWAGGER
	@RequestMapping(value = "/file/Extension", method = RequestMethod.GET)
	public ResponseEntity<String> isValidERxtension() {
		// checking for the valid fileExtension

		if (fs.isCorrectExtension() == true) {

			// if the file extension is valid..
			return new ResponseEntity<String>("VALID FILE EXTENSION", HttpStatus.OK);
		} else {

			// else show this..
			return new ResponseEntity<String>("INVALID FILE EXTENSION ", HttpStatus.BAD_REQUEST);
		}
	}

	// CALLING POST METHOD VIA SWAGGER
	@RequestMapping(value = "/file/add", method = RequestMethod.POST)
	public void setFileDataInDb() {
		
		// save the data ..
		fs.saveFileData();
	}

}
