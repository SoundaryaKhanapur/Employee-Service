package com.git.company.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.git.company.employeeservice.EmployeeServiceApplication;
import com.git.company.employeeservice.domain.Employee;
import com.git.company.employeeservice.repository.EmployeeRepository;
import com.git.company.employeeservice.service.EmployeeService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@Api(value = "EmployeeServiceController", description = "REST Apis related to Employee Service!!!")
@RequestMapping("/employee-service")
public class EmployeeController {
	
	private EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}
	
	@GetMapping(value = "/{id}")
	public Employee getEmployee(@PathVariable("id") int employee_id) throws Exception {
	return employeeService.getEmployee(employee_id);
		
	}
	
	@PostMapping("/")
	@ResponseStatus(value=HttpStatus.CREATED)
	public Employee addEmployee(@RequestBody Employee e) throws Exception {
		
		return employeeService.addEmployee(e);
		}
	
	
	
	@PutMapping("/")
	public Employee editEmployee(@RequestBody Employee e) throws Exception {
		
		return employeeService.editEmployee(e);		
	
	}

	
	
	@DeleteMapping(value = "/{id}")
	public String deleteEmployee(@PathVariable("id") int id ) throws Exception {
		return employeeService.deleteEmployee(id);
		
	}

	

	
}
