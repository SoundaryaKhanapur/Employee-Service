package com.git.company.employeeservice.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.git.company.employeeservice.repository.EmployeeRepository;

public class Employee {
	
	private int id;
	private String name;
	private int age;
	private Type employee_type;
	private int manager_id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Type getEmployee_type() {
		return employee_type;
	}

	public void setEmployee_type(Type employee_type) {
		this.employee_type = employee_type;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public enum Type{
		MANAGER, SOFTWARE_DEVELOPER, SITE_ADMIN, CONTRACTOR
	}
	

	public Employee() {
		
	}

	
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", employee_type=" + employee_type
				+ ", manager_id=" + manager_id + "]";
	}

}
