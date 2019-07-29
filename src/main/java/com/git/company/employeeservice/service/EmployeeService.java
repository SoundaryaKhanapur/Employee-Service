package com.git.company.employeeservice.service;

import com.git.company.employeeservice.domain.Employee;

public interface EmployeeService {
	
	public Employee getEmployee(int employee_id) throws Exception;
	
	public Employee addEmployee(Employee e) throws Exception;
	
	public Employee editEmployee(Employee e) throws Exception;
	
	public String deleteEmployee(int id ) throws Exception;

}
