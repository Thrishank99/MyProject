package com.org.java.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class EmployeeDto {
	
	private int empId;
	private String name;
	private double salary;
	private int departmentId;
	private String deptName;

}
