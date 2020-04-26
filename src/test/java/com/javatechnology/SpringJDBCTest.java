package com.javatechnology;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import com.javatechnology.dao.EmployeeDao;
import com.javatechnology.model.Employee;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SpringJDBCTest {
	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private MockMvc mvc;
	private static final String INSERT_SQL="insert into employee(name,designation,salary,address) values(?,?,?,?)";
	private static final String GET_QSL="select * from employee where id=?";
	private static final String UPDATE_SQL="update employee set name=?,designation=?,salary=?,address=? where id=?";
	private static final String DELETE_SQL="delete from employee where id=?";
	private final static String GET_ALLEMPLOYEE="select * from employee";
	@Test
	public void test() {
		Employee emp=new Employee();
		emp.setAddress("SpringbootTest");
		emp.setDesignation("SpringbootTestDesignation");
		emp.setName("SpringbootTestName");
		emp.setSalary(1200.0);
		
		try {
			mvc.perform(put("/updateEmpl").accept(MediaType.APPLICATION_JSON).param("emp", "{ 'name:emp.getName()}")).andExpect(status().isOk());
			mvc.perform(post("/signupProcess")).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		template.update(INSERT_SQL, emp.getName(),emp.getDesignation(),emp.getSalary(),emp.getAddress());
		
		
	}
	

}
