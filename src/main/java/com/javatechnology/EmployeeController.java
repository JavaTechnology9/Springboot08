package com.javatechnology;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechnology.dao.EmployeeDao;
import com.javatechnology.model.Employee;

//@Controller
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao dao;
	
	@RequestMapping("/employee")
	public String getEmployee(Model model) {
		model.addAttribute(new Employee());
		return "employee";
	}
	@PostMapping("/employeeProcess")
	public String employeeProcess(@RequestBody Employee employee) {
		dao.saveEmployee(employee);
		return "home";
	}
	@PostMapping("/updateEmpl")
	public @ResponseBody Employee updateEmployee(@RequestBody Employee employee){
		return dao.updateEmployee(employee);
		
	}
	@DeleteMapping("/deleteEmp/{id}")
	//@PatchMapping
	public Employee deleteEmployee(@PathVariable("id") long id) {
		return dao.deleteEmployee(id);
		
	}
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> allEmployees = dao.getAllEmployees();
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
		
	}
	

}
