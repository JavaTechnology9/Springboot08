package com.javatechnology.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.javatechnology.model.Employee;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_SQL="insert into employee(name,designation,salary,address) values(?,?,?,?)";
	private static final String GET_QSL="select * from employee where id=?";
	private static final String UPDATE_SQL="update employee set name=?,designation=?,salary=?,address=? where id=?";
	private static final String DELETE_SQL="delete from employee where id=?";
	private final static String GET_ALLEMPLOYEE="select * from employee";
	@Override
	public String saveEmployee(Employee employee) {
		jdbcTemplate.update(INSERT_SQL, 
				employee.getName(),employee.getDesignation(),
				employee.getSalary(),employee.getAddress());
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee queryForObject = jdbcTemplate.queryForObject(GET_QSL, new Object[] {employee.getId()}, 
				new BeanPropertyRowMapper<>(Employee.class));
		/*queryForObject.setName(employee.getName());
		queryForObject.setAddress(employee.getAddress());
		queryForObject.setSalary(employee.getSalary());
		queryForObject.setDesignation(employee.getDesignation());*/
		//saveEmployee(queryForObject);
		int count = jdbcTemplate.update(UPDATE_SQL, employee.getName(),employee.getDesignation(),
				employee.getSalary(),employee.getAddress(),employee.getId());
		if(count>0)
			return employee;
		else
			return queryForObject;
		
	}

	@Override
	public Employee deleteEmployee(long id) {
		Employee queryForObject = jdbcTemplate.queryForObject(GET_QSL, new Object[] {id}, 
				new BeanPropertyRowMapper<>(Employee.class));
		int count = jdbcTemplate.update(DELETE_SQL, id);
		return queryForObject;
	}

	@Override
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		//return jdbcTemplate.queryForList(GET_ALLEMPLOYEE, Employee.class);
		List<Employee> employee=jdbcTemplate.query(GET_ALLEMPLOYEE, new BeanPropertyRowMapper(Employee.class));
		return employee;
		//return null;
	}

}
