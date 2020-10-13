package com.assignment;

public class MyUser {
	public String name;
	public String id;
	public String salary;

	public MyUser() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public MyUser(String name, String id, String salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "MyUser [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}

}
