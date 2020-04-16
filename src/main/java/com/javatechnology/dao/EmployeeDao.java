package com.javatechnology.dao;

import java.util.List;

import com.javatechnology.model.Employee;

public interface EmployeeDao {
	String saveEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee deleteEmployee(long id);
	Employee getEmployee(long id);
	List<Employee> getAllEmployees();
}
