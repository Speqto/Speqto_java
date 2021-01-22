package com.speqto.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.speqto.entity.Employee;
import com.speqto.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "/saveEmployee", consumes = { "application/json" })
	ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {
		String msg="";
		
	
		boolean saveEmployee = employeeService.saveEmployee(emp);
		if (saveEmployee) {
			msg = "Employee Saved Successfully";
			
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			msg = "Failed to Save Employee";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping(value = "/getAllEmployee")
	List<Employee> getAllEmployee() {
		List<Employee> list = employeeService.getAllEmployee();

		return list;
	}

	@GetMapping(value = "getId/{id}", produces = { "application/json" })
	Employee getEmployeeById(@PathVariable("id") Integer id) {
		Employee empObj = employeeService.getEmployeeById(id);
		return empObj;
	}

	@DeleteMapping(value = "deleteById/{id}")
	String deleteById(@PathVariable("id") Integer id) {
		String msg = "";
		boolean deleteEmployeeById = employeeService.deleteEmployeeById(id);

		if (deleteEmployeeById) {
			msg = "Employee Record Deleted Successfully..!!";
		} else {
			msg = "Failed to Delete Record..!";
		}
		return msg;

	}

	@PutMapping("/updateEmployee/{id}")
	String update(@RequestBody Employee emp, @PathVariable("id") Integer id)
	{
		
		
		String msg="";
		
		 Employee empObj = employeeService.getEmployeeById(id);
		if(empObj.getEmployeeId()!=null)
		{

		employeeService.saveEmployee(emp);
		 msg="Employee Update Successfully..!";
		 }
		
		else {
			msg="failed to Update Emplloyee..!";
		}
		return msg;
	}
		

	}
