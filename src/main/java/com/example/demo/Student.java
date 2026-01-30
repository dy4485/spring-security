package com.example.demo;

public class Student {
	private int  id;
    private String Name;
    private String salary;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Student(int id, String name, String salary) {
		super();
		this.id = id;
		this.Name = name;
		this.salary = salary;
	}
	
	
    
    
    
    

}
