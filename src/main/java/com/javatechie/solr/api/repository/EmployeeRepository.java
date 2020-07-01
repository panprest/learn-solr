package com.javatechie.solr.api.repository;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.javatechie.solr.api.model.Employee;

public interface EmployeeRepository extends SolrCrudRepository<Employee, Integer>{
	
//	Employee findByName(String name);
	
	@Query(requestHandler = "/select")
	Employee findByName(String productId);
}
