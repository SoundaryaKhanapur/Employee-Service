package com.git.company.employeeservice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Employee {
	
	private static int count = 0;
	int id;
	String name;
	int age;
	Type employee_type;
	int manager_id;
	
	
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

	enum Type{
		MANAGER, SOFTWARE_DEVELOPER, SITE_ADMIN, CONTRACTOR
	}
	static Map<Integer, Employee> employeeMap = new ConcurrentHashMap<>();

	public Employee() {
		
	}
	
	public static Employee addEmployee(Employee e) throws Exception
	{
		if(e.employee_type.equals(Type.SOFTWARE_DEVELOPER) && (null == employeeMap.get(e.manager_id) ))
		{
			throw new Exception("Manager not found!");
			
		}
		else if(e.employee_type.equals(Type.SITE_ADMIN) && e.manager_id != 0) {
			
			throw new Exception("Site Admin does not have a Manager");
			
		}
		e.id = ++count;
		employeeMap.put(e.id, e);
		
		return e;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", employee_type=" + employee_type
				+ ", manager_id=" + manager_id + "]";
	}

}
