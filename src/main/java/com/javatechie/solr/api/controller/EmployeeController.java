package com.javatechie.solr.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.solr.api.model.Employee;
import com.javatechie.solr.api.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostConstruct
	public void addEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(373, "Basant", new String[] {"Bangalore","BIN"}));
		employees.add(new Employee(908, "Santosh", new String[] {"Hyderbad","XYZ"}));
		employees.add(new Employee(321, "Basanto", new String[] {"Pune","PQR"}));
		employeeRepository.saveAll(employees);
	}
	
	@GetMapping("/getAll")
	public Iterable<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/getEmployee/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		return employeeRepository.findByName(name);
	}
}
