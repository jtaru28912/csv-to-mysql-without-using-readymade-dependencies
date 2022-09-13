package com.assignment.service;

import java.io.BufferedReader;

import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entity.Employee;
import com.assignment.repo.EmployeeRepo;

@Service
public class EmpService {
	//DI
	@Autowired
	private EmployeeRepo repo;

	String line = "";

	public void saveData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/SampleEmployee.csv"));
			int rowN= 0;
			//logic for skipping the 1st row as it will be the heading
			while ((line = br.readLine()) != null ) {
				if(rowN==0) {
					rowN++;
					continue;
				}
				String[] data = line.split(",");
				Employee e = new Employee();
				e.setFirstName(data[0]);
				e.setMiddleName(data[1]);
				e.setLastName(data[2]);
				e.setAge(data[3]);
				e.setSalary(data[4]);
				e.setEmailId(data[5]);
				
				repo.save(e);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
}
