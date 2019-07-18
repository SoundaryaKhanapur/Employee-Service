package com.git.company.employeeservice.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.git.company.employeeservice.domain.Employee;

@Service
public class EmployeeRepository {

	private static Map<Integer, Employee> employeeMap = new ConcurrentHashMap<>();
	
	public Employee getEmployee(int employee_id)
	{
		return employeeMap.get(employee_id);
		
	}
	
	
	public Employee addEmployee(Employee e)
	{
		
		return employeeMap.put(e.getId(),e);
	}
	
	public void deleteEmployee(int employee_id)
	{
		employeeMap.remove(employee_id);
	}
	
	
}
