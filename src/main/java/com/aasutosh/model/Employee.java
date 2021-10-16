package com.aasutosh.model;

import java.time.LocalDate;

public class Employee {
	private Integer empId;
	private String empName;
	private Long salary;
	private String gender ;
	private String empMotherName;
	private LocalDate dateOfJoin;
	
	
	public Employee() {}
	
	public Employee(Integer empId, String empName, Long salary, String gender, String empMotherName,
			LocalDate dateOfJoin) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.gender = gender;
		this.empMotherName = empMotherName;
		this.dateOfJoin = dateOfJoin;
	}

	public Employee(Integer empId, String empName, Long salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmpMotherName() {
		return empMotherName;
	}

	public void setEmpMotherName(String empMotherName) {
		this.empMotherName = empMotherName;
	}

	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", gender=" + gender
				+ ", empMotherName=" + empMotherName + ", dateOfJoin=" + dateOfJoin + "]";
	}
	
	 

}
