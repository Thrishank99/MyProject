
package com.org.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.org.java.entity.Employee;
import com.org.java.repository.EmployeeRepository;
import com.org.java.service.EmployeeService;

@SpringBootTest
class ThrishankJavaApplicationTests {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void saveTest() {
		Employee emp = new Employee(105, "naveen", 5, 8, "775");
		when(employeeRepository.save(emp)).thenReturn(emp);
		assertEquals(emp, employeeService.saveEmployeeDetails(emp));
	}

	@Test
	public void updateTest() {
		  when(employeeRepository.findAll()).thenReturn(Stream .of(new
				  Employee(102,"Danile", 35.0,55, "Govt"), 
				  new Employee(102,"Danile", 35.0,55, "Govt"), 
				  new Employee(102,"Danile", 35.0,55, "Govt")).collect(Collectors.toList()));	
		  assertEquals(3,employeeService.findAllEmployeeDetails().size());
		Employee emp = new Employee(102, "prakash", 78.0, 45, "testdept");
		when(employeeRepository.save(emp)).thenReturn(emp);
		assertEquals(emp, employeeService.updateEmployeeDetails(emp));
	}

	@Test
	public void deleteTest() {
		when(employeeRepository.findAll()).thenReturn(Stream .of(new
				  Employee(102,"Danile", 35.0,55, "Govt"), 
				  new Employee(102,"Danile", 35.0,55, "Govt"), 
				  new Employee(102,"Danile", 35.0,55, "Govt")).collect(Collectors.toList()));	
		  assertEquals(3,employeeService.findAllEmployeeDetails().size());
		Employee emp = new Employee(102,"Danile", 35.0,55, "Govt");
		employeeService.deleteEmployeeDetails(emp);
		verify(employeeRepository,times(1)).delete(emp); 
	} 
	@Test 
	  public void findAllEmployeeTest() {
		  when(employeeRepository.findAll()).thenReturn(Stream .of(new
		  Employee(100,"Danile", 35.0,55, "Govt"), 
		  new Employee(100,"Danile", 35.0,55, "Govt"), 
		  new Employee(100,"Danile", 35.0,55, "Govt")).collect(Collectors.toList()));
		  assertEquals(3,
		employeeService.findAllEmployeeDetails().size()); }

	@Test
	public void findByNameTest() {
		String Name = "Govt";
		when(employeeRepository.findByName(Name))
				.thenReturn(Stream.of(new Employee(101, "Danile", 35, 55500, "Govt")).collect(Collectors.toList()));
		assertEquals(1, employeeService.findByEmployeNameDeatails(Name).size());
	}
	@Test
	public void findByDepartmentTest() {
		String Name = "Govt";
		when(employeeRepository.findByDeptName(Name))
				.thenReturn(Stream.of(new Employee(101, "Danile", 35, 55500, "Govt")).collect(Collectors.toList()));
		assertEquals(1, employeeService.findByEmployedeptNameDeatails(Name).size());
	}

	@Test
	public void findByIdEmployeeTest() {
		int employeeId = 1;
		Employee emp = new Employee(employeeId, "srinu", 5558.0, 505, "Muncipality");
		doReturn(Optional.of(emp)).when(employeeRepository).findByEmpId(employeeId);
		Optional<Employee> emp1 = employeeService.findByEmployeeIdDeatails(employeeId);
		assertNotNull(emp1, "Employee with employeeId : " + employeeId + " not found");

		assertEquals(employeeId, emp1.get().getEmpId());
		assertEquals(emp.getName(), emp1.get().getName());
		assertEquals(emp.getSalary(), emp1.get().getSalary());
		assertEquals(emp.getDepartmentId(), emp1.get().getDepartmentId());
		assertEquals(emp.getDeptName(), emp1.get().getDeptName());
	}

}
