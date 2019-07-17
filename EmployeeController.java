package com.git.company.employeeservice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@Api(value = "EmployeeServiceController", description = "REST Apis related to Employee Service!!!")
@RequestMapping("/employee-service")
public class EmployeeController {
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Get Employee", response = Employee.class ,nickname = "Get Employee")
	public Employee getEmployee(@PathVariable("id") int employee_id) throws Exception {
		if(null != Employee.employeeMap.get(employee_id))
		{
			System.out.println("Employee_ID: " + employee_id);
		
		return Employee.employeeMap.get(employee_id);
		}
		else
		{
			throw new EmployeeServiceApplication.EmployeeNotFoundException(); 
		}
		
	}
	@PostMapping("/")
	@ApiOperation(value = "Add Employee", response = Employee.class ,nickname = "ADD Employee")
	public Employee addEmployee(@RequestBody Employee e) throws Exception {
		
	e = Employee.addEmployee(e);
		System.out.println(e);
		
		return e ;
		
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Edit Employee", response = Employee.class ,nickname = "Edit Employee")
	public Employee putEmployee( @PathVariable("id") int employee_id, @RequestBody Employee e) throws Exception {
		
		if(null != Employee.employeeMap.get(employee_id))
		{
	
			
			 e = Employee.editEmployee(e,employee_id);
			System.out.println(e);
			
			return e ;
			
		}
		else
		{
			throw new EmployeeServiceApplication.EmployeeDoesNotExistException(); 
		}
		
	
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Delete Employee", response = String.class ,nickname = "Delete Employee")
	public String deleteEmployee(@PathVariable("id") int id ) throws Exception {
		if(null != Employee.employeeMap.get(id))
		{
			Employee.employeeMap.remove(id);
			return "Employee Deleted";
		}
		else
		{
			throw new EmployeeServiceApplication.EmployeeAlreadyDeletedException(); 
		}
		
		
	}
	
	
	
}
