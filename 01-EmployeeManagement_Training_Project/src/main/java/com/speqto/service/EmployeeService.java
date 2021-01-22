package com.speqto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.speqto.entity.Employee;


public interface EmployeeService {
	
	boolean saveEmployee(Employee emp);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(Integer id);
	
	boolean deleteEmployeeById(Integer id);
	
	boolean updateEmployee(Integer id);
	

}
