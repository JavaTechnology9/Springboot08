package com.javatechnology.jersey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechnology.model.Employee;
@Repository("jerseyRepository")
public interface JerseyRepository extends JpaRepository<Employee, Long>{

}
