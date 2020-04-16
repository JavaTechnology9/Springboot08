package com.javatechnology.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechnology.model.Employee;
@Repository("hibernateDao")
public interface EmployeeDao extends JpaRepository<Employee, Long>{
	
	//Employee saveEmployee(Employee  employee);
	

}
