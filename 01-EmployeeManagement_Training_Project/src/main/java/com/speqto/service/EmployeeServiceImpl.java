package com.speqto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speqto.entity.Employee;
import com.speqto.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	

	@Override
	
	public boolean saveEmployee(Employee emp) {
	Employee empObj = employeeRepo.save(emp);			
		return empObj!=null && empObj.getEmployeeId()!=null ;
		
	}

	@Override
	public List<Employee> getAllEmployee() {

		return employeeRepo.findAll();
		
	}

	@Override
	public Employee getEmployeeById(Integer id) {

		Optional<Employee> findById = employeeRepo.findById(id);
		if(findById.isPresent()) {
			Employee employee = findById.get();
			return employee;
		}
		return null;
	}

	@Override
	public boolean deleteEmployeeById(Integer id) {

		 employeeRepo.deleteById(id);
	
		return true;
	}

	@Override
	public boolean updateEmployee(Integer id) {
		
		
		return false;
	}



}
