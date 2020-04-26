package com.javatechnology;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechnology.model.Employee;

@SpringBootTest
@AutoConfigureMockMvc
public class MVCTest {
	@Autowired
	private MockMvc mvc;
	@Test
	public void test() {
		try {
			Employee emp=new Employee();
			emp.setAddress("USAUpdate");
			emp.setId(11);
			emp.setDesignation("USAUpdate");
			emp.setName("USAUpdate");
			emp.setSalary(145065.0);
			HttpHeaders header=new HttpHeaders();
			header.add("content-type", "application/json");
			ObjectMapper objectMapper=new ObjectMapper();
			String writeValueAsString = objectMapper.writeValueAsString(emp);
			//mvc.perform(get("/")).andExpect(status().isOk());
			//mvc.perform(get("/signup")).andExpect(status().isOk());
			//mvc.perform(post("/employeeProcess").accept(MediaType.APPLICATION_JSON_VALUE)
					//.content(writeValueAsString).headers(header)).andExpect(status().isOk());
			
			//mvc.perform(post("/updateEmpl").accept(MediaType.APPLICATION_JSON_VALUE)
					//.content(writeValueAsString).headers(header)).andExpect(status().isOk());
			
			mvc.perform(delete("/deleteEmp/11").accept(MediaType.APPLICATION_JSON_VALUE)
					/* .content(writeValueAsString) */.headers(header)).andExpect(status().isOk());
			
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
