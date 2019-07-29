package com.git.company.employeeservice.repository;

import com.git.company.employeeservice.domain.Employee;

public interface EmployeeRepository {
	public Employee getEmployee(int employee_id);
	
	public Employee addEmployee(Employee e);
	
	public void deleteEmployee(int employee_id);
	
}
