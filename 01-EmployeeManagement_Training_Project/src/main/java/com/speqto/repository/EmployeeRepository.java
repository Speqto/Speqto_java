package com.speqto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.speqto.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {

}
