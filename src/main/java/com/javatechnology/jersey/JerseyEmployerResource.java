package com.javatechnology.jersey;

import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.javatechnology.model.Employee;

@Path("/JerseyResource")
public class JerseyEmployerResource {
	@Autowired
	private JerseyRepository repository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveEmployee(Employee employee) {
		Employee save = repository.save(employee);
		return Response.ok(save).build();
		
	}
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@PathParam("id") long id,Employee employee) { 
		Employee findById = repository.findById(id).get();
		findById.setName(employee.getName());
		findById.setAddress(employee.getAddress());
		findById.setSalary(employee.getSalary());
		findById.setDesignation(employee.getDesignation());
		repository.save(findById);
		return Response.ok(findById).build();
	}

}
