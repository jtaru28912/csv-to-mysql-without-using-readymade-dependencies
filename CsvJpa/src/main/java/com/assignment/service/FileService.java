package com.assignment.service;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entity.FileEntity;
import com.assignment.repo.FileRepo;

@Service
public class FileService {
	// DI
	@Autowired
	private FileRepo fr;

	// creating object of File.io class for using inbuilt functions
	File f = new File("src/main/resources/SampleEmployee.csv");

	// get number of lines/records
	public String numberofRecords() {

		// initially the value of line is 0
		long lines = 0;

		// for taking the input BuffreReader is used
		try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/SampleEmployee.csv"))) {
			while (reader.readLine() != null)
				lines++;
		} catch (IOException e) {
			e.printStackTrace();
		}

		// excluding headings as a record count
		// parsing the value into String
		String s = String.valueOf(lines - 1);
		return s;
	}

	// creating the object of Date class
	Date date = new Date();

	long insert = f.getTotalSpace();

	// type casting
	String insertCount = String.valueOf(insert);

	// this will check for duplicates
	public boolean checkduplicate() {

		// set is a datastructure used to store the values/records
		Set<String> duplicateFile = new HashSet<>();
		List<FileEntity> filename = new ArrayList<>();
		for (FileEntity fe : filename) {
			duplicateFile.add(fe.getfName());
		}
		if (duplicateFile.size() != 1) {
			return true;
		} else {
			return false;
		}
	}

	public String saveFileData() {
		// checking that if the size is valid and if the giving extension is also valid
		if (isValid() && isCorrectExtension()) {

			// creating object of our entity class
			FileEntity file = new FileEntity();

			// filename
			file.setfName(f.getName());

			// creation date
			// using SimpleDateformat to represent in dfate format
			file.setCreateDate(new SimpleDateFormat("E yyyy.MM.dd").format(date));

			// insertcount
			file.setInsertCount(insertCount);

			// num of records
			file.setNoOfRecords(numberofRecords());

			// update
			// using SimpleDateformat to represent in dfate format
			file.setUpdatedDate(new SimpleDateFormat("E yyyy.MM.dd").format(f.lastModified()));
			fr.save(file);
			return "Record Saved Successfully";
		}
		// if the extension dont match or the size is greater than what is asked ...
		else
			return "Unsuccessful attempt";
	}

	// check file validation of file size
	public boolean isValid() {
		long size = f.length();

		// size>20MB
		if (size > 20 * 1024 * 1024) {
			return false;
		}
		return true;
	}

	// checking file extensions and including other extensioms
	public boolean isCorrectExtension() {
		String fileName = f.getName().toUpperCase();
		boolean extension = fileName.endsWith(".CSV") || fileName.endsWith(".ODS");
		if (!extension)
		// if file name is true ie in form of ods or csv return true else false
		{
			return false;
		} else
			return true;
	}

}
