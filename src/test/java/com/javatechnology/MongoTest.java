package com.javatechnology;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.javatechnology.mongo.Employee;



@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MongoTest {
	@Autowired
	private MongoTemplate template;
	@Test
	public void test() {
		Employee emp=new Employee();
		emp.setAddress("USAUpdate");
		//emp.setId(11);
		emp.setDesignation("USAUpdate");
		emp.setName("USAUpdate");
		emp.setSalary("145065.0");
		//template.save(emp);
		Employee findOne = template.findOne(Query.query(Criteria.where("name").is("USAUpdate")), Employee.class);
		assertThat(findOne.getName()).isEqualTo(emp.getName());
		
	}

}
