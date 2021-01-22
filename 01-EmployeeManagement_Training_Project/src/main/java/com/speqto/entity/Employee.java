package com.speqto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Data
@Entity
@Table(name="EMPLOYEE_DTLS")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name="EMPLOYEE_ID")
	private Integer employeeId;
	@Column(name="EMPLOYEE_NAME")
	private String employeeName;
	@Column(name="EMPLOYEE_EMAIL")
	private String employeeEmail;
	@Column(name="EMPLOYEE_SALARY")
	private Double employeeSalary;
	

}
