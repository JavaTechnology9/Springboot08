package com.javatechnology.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MongoResource {
	@Autowired
	private MongoTemplate template;
	@PostMapping(value="/saveMongoEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee saveEmployee(@RequestBody Employee employee) {
		template.save(employee);
		return employee;
	}
	@GetMapping("/getMongoEmployees")
	public List<Employee> getAllEmployees(){
		return template.findAll(Employee.class);
	}
	@PutMapping(value="/updateMongoEmployee",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmployee(@RequestBody Employee employee) {
		/*Employee findOne = template.findOne(Query.query(Criteria.where("id").is(employee.getId())), Employee.class);
		findOne.setAddress(employee.getAddress());
		findOne.setDesignation(employee.getDesignation());
		findOne.setId(employee.getId());
		findOne.setName(employee.getName());
		findOne.setSalary(employee.getSalary());*/
		
		/*Query query=new Query();
		query.addCriteria(Criteria.where("id").is(employee.getId()));
		Update update =new Update();
		update.set("name", employee.getName());
		template.findAndModify(query, update, Employee.class);*/
		//template.findById(id, entityClass)
		//template.find(query, entityClass, collectionName)
		return template.save(employee);
		
	}
	@DeleteMapping("/deleteMongoEmployee/{Id}")
	public void deleteEmployee(@PathVariable("Id") String id) {
		Query query=new Query();
		query.addCriteria(Criteria.where("id").is(id));
		template.remove(query, Employee.class);
	}
	
	@GetMapping("/deleteMongoEmployee/{name}")
	public void finEmployeeByName(@PathVariable("name") String name) {
		Query query=new Query();
		query.addCriteria(Criteria.where("name").is(name));
		template.find(query, Employee.class);
	}

}
