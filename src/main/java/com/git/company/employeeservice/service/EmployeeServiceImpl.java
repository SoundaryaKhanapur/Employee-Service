package com.git.company.employeeservice.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.git.company.employeeservice.EmployeeServiceApplication;
import com.git.company.employeeservice.controller.EmployeeController;
import com.git.company.employeeservice.domain.Employee;
import com.git.company.employeeservice.domain.Employee.Type;
import com.git.company.employeeservice.repository.EmployeeRepository;

import io.swagger.annotations.ApiOperation;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static AtomicInteger count = new AtomicInteger(0);
	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
		
	}
	
	EmployeeRepository repository;
	
	
	@ApiOperation(value = "Get Employee", response = Employee.class ,nickname = "Get Employee")
	public Employee getEmployee(int employee_id) throws Exception {
		if(null != repository.getEmployee(employee_id))
		{
		
		
		return repository.getEmployee(employee_id);
		}
		else
		{
			throw new EmployeeNotFoundException(); 
		}
		
	}

	@ApiOperation(value = "Add Employee", response = Employee.class ,nickname = "ADD Employee")
	  
	public Employee addEmployee(Employee e) throws Exception
	{
		if(e.getEmployee_type().equals(Employee.Type.SOFTWARE_DEVELOPER) && (null == repository.getEmployee(e.getManager_id()) ))
		{
			throw new ManagerNotFoundException(); 
			
		}
		else if(e.getEmployee_type().equals(Type.SITE_ADMIN) && e.getManager_id() != 0) {
			
			throw new ManagerFoundException();
			
		}
		else if(e.getEmployee_type().equals(Employee.Type.MANAGER) && (e.getManager_id() > 0) && (null == repository.getEmployee(e.getManager_id()) ))
		{
			throw new InvalidManagerException(); 
		}
		
		
		e.setId(count.addAndGet(1));
		repository.addEmployee(e);
		
		return e;
	}

	@ApiOperation(value = "Edit Employee", response = Employee.class ,nickname = "Edit Employee")
	public Employee editEmployee(Employee e) throws Exception {
		
		if(null != repository.getEmployee(e.getId()))
		{
			
			if(e.getEmployee_type().equals(Employee.Type.SOFTWARE_DEVELOPER) && (null == repository.getEmployee(e.getManager_id()) ))
			{
				throw new ManagerNotFoundException(); 
				
			}
			else if(e.getEmployee_type().equals(Type.SITE_ADMIN) && e.getManager_id() != 0) {
				
				throw new ManagerFoundException();
				
			}
			
			repository.addEmployee(e);
			
			return e;
				}
		else
		{
			throw new EmployeeDoesNotExistException(); 
		}
		
	
	}
	
	@ApiOperation(value = "Delete Employee", response = String.class ,nickname = "Delete Employee")
	public String deleteEmployee(int id ) throws Exception {
		if(null != repository.getEmployee(id))
		{
			repository.deleteEmployee(id);
			return "Employee Deleted";
		}
		else
		{
			throw new EmployeeAlreadyDeletedException(); 
		}
		
		
	}
	
	
	  @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee Not Found")  // 404
	    public static class EmployeeNotFoundException extends RuntimeException {
	        
	    }
	    
	    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Looks like Employee is already deleted or does not exist")  // 404
	    public static class EmployeeAlreadyDeletedException extends RuntimeException {
	        
	    }
	    
	    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee does not exist")  // 404
	    public static class EmployeeDoesNotExistException extends RuntimeException {
	        
	    }
	   
	    @ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Software Developer must have a manager")  // 403
	    public static class ManagerNotFoundException extends RuntimeException {
	        
	    }
	    
	    @ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Site Admin dose not have a manager")  // 403
	    public static class ManagerFoundException extends RuntimeException {
	        
	    }
	    
	    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Invalid Manager ID")  // 404
	    public static class InvalidManagerException extends RuntimeException {
	        
	    }
	    
}

