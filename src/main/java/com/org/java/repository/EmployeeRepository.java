package com.org.java.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.java.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByName(String name);

	List<Employee> findByDeptName(String deptName);

	@Query("SELECT e FROM Employee e WHERE e.name=:name and e.deptName=:deptName")
	Employee findByNameAndDeptName(@Param("name") String name,@Param("deptName") String deptName);
	
	@Query("SELECT e FROM Employee e WHERE e.empId=:empId and e.name=:name and e.deptName=:deptName")
	Employee findByEmpIdAndNameAndDeptName(@Param("empId") int empId,@Param("name") String name, @Param("deptName") String deptName);

	@Query("SELECT e FROM Employee e WHERE e.empId=:empId")
	Optional<Employee> findByEmpId(@Param("empId") int empId);

}
