package com.org.java.serviceimpl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.org.java.entity.Employee;
import com.org.java.exception.EmptyInputException;
import com.org.java.exception.NoDataAvailableException;
import com.org.java.repository.EmployeeRepository;
import com.org.java.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		if (employee.getName().isEmpty() || employee.getName().length() == 0) {
			throw new EmptyInputException("600", "given input is empty");
		} else if (employee.getDeptName().isEmpty() || employee.getDeptName().length() == 0) {
			throw new EmptyInputException("600", "given input is empty");
		}

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAllEmployeeDetails() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		if (list.isEmpty()) {
			throw new NoDataAvailableException("600", "No Data available");
		}
		return list;
	}

	@Override
	public Employee updateEmployeeDetails(Employee employee) {
		List<Employee> list = employeeRepository.findAll();
		List<Integer> empIds = list.stream().map(s1 -> s1.getEmpId()).collect(Collectors.toList());
		if (!empIds.contains(employee.getEmpId())) {
			throw new NoDataAvailableException("600", "No Data available");
		}
		return employeeRepository.save(employee);

	}

	@Override
	public Employee deleteEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		List<Integer> empIds = list.stream().map(s1 -> s1.getEmpId()).collect(Collectors.toList());
		if (!empIds.contains(employee.getEmpId())) {
			throw new NoDataAvailableException("600", "No Data available");
		}
		employeeRepository.delete(employee);
		return employee;

	}

	@Override
	public List<Employee> findByEmployeNameDeatails(String name) {
		// TODO Auto-generated method stub
		List<Employee> findByName = employeeRepository.findByName(name);
		if (findByName.contains(name) || findByName.isEmpty()) {
			throw new NoDataAvailableException("600", "No Data available");
		}
		return findByName;
	}

	@Override
	public List<Employee> findByEmployedeptNameDeatails(String deptName) {
		// TODO Auto-generated method stub
		List<Employee> findByDeptName = employeeRepository.findByDeptName(deptName);
		if (findByDeptName.contains(deptName) || findByDeptName.isEmpty()) {
			throw new NoDataAvailableException("600", "No Data available");
		}
		return findByDeptName;
	}

	@Override
	public List<Employee> findByEmployeeSalaryAscDeatails() {
		List<Employee> list = employeeRepository.findAll();
		if (list.isEmpty()) {
			throw new NoDataAvailableException("600", "No Data available");
		}
		List<Employee> ascsort = list.stream()
				.sorted((s1, s2) -> s1.getSalary() < s2.getSalary() ? -1 : s2.getSalary() < s2.getSalary() ? 1 : 0)
				.collect(Collectors.toList());

		/*
		 * List<Employee> ByIDAscSorted =
		 * list.stream().sorted(Comparator.comparing(Employee::getEmpId)).collect(
		 * Collectors.toList()); return ByIDAscSorted;
		 */

		return ascsort;
	}

	@Override
	public List<Employee> findByEmployeeSalaryDscDeatails() {
		List<Employee> list = employeeRepository.findAll();
		if (list.isEmpty()) {
			throw new NoDataAvailableException("600", "No Data available");
		}
		List<Employee> dscsort = list.stream()
				.sorted((s1, s2) -> s1.getSalary() > s2.getSalary() ? -1 : s2.getSalary() > s1.getSalary() ? 1 : 0)
				.collect(Collectors.toList());

		return dscsort;
		/*
		 * List<Employee> ByIdDscSorted =
		 * list.stream().sorted(Comparator.comparing(Employee::getEmpId).reversed()).
		 * collect(Collectors.toList()); return ByIdDscSorted;
		 */
	}

	@Override
	public List<Employee> findByEmployeeIdEvenDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<Employee> evenIds = list.stream().filter(s1 -> s1.getEmpId() % 2 == 0).collect(Collectors.toList());
		if(evenIds.isEmpty()) {
			throw new NoDataAvailableException("600", "No Data available");
		}
		return evenIds;
	}

	@Override
	public List<Employee> findByEmployeeIdOddDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<Employee> oddIds = list.stream().filter(s1 -> s1.getEmpId() % 2 != 0).collect(Collectors.toList());
		if(oddIds.isEmpty()) {
			throw new NoDataAvailableException("600", "No Data available");
		}
		return oddIds;
	}

	@Override
	public Employee findByMaxSalaryDeatails() {
		List<Employee> list = employeeRepository.findAll();
		// Employee
		// maxSalary=list.stream().max((s1,s2)->s1.getSalary()<s2.getSalary()?-1:s1.getSalary()<s2.getSalary()?1:0).get();
		Employee maxSalaryEmployee = list.stream().max(Comparator.comparingDouble(s1 -> s1.getSalary())).get();
		return maxSalaryEmployee;
		// return maxSalary;
	}

	@Override
	public Employee findByMinSalaryDeatails() {
		List<Employee> list = employeeRepository.findAll();
		// Employee
		// minSalary=list.stream().min((s1,s2)->s2.getSalary()>s1.getSalary()?-1:s1.getSalary()>s2.getSalary()?1:0).get();
		Employee minSalaryEmployee = list.stream().min(Comparator.comparingDouble(s1 -> s1.getSalary())).get();
		return minSalaryEmployee;
		// return minSalary;
	}

	@Override
	public double findBySumSalaryDeatails() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		double sumSalary = list.stream().mapToDouble(s1 -> s1.getSalary()).summaryStatistics().getSum();
		return sumSalary;
	}

	@Override
	public double findByCountSalaryDeatails() {
		List<Employee> list = employeeRepository.findAll();
		double countSalary = list.stream().mapToDouble(s1 -> s1.getSalary()).summaryStatistics().getCount();
		return countSalary;
	}

	@Override
	public List<Employee> findParticularRecordsDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<Employee> records = list.stream().skip(2).limit(5).collect(Collectors.toList());
		if (records.isEmpty()) {
			throw new NoDataAvailableException("600", "No Data available");
		}
		return records;
	}

	@Override
	public Set<Employee> printDublicateRecordsDeatails() {
		Set<Double> set = new HashSet<Double>();
		List<Employee> list = employeeRepository.findAll();
		Set<Employee> dublicates = list.stream().filter(s1 -> !set.add(s1.getSalary())).collect(Collectors.toSet());
		if (dublicates.isEmpty()) {
			throw new NoDataAvailableException("600", "No Data available");
		}
		return dublicates;
	}

	@Override
	public Set<Double> printWithoutDublicateRecordsDeatails() {
		Set<Double> set = new HashSet<Double>();
		List<Employee> list = employeeRepository.findAll();
		Set<Employee> dublicates = list.stream().filter(s1 -> !set.add(s1.getSalary())).collect(Collectors.toSet());
		if (dublicates.isEmpty()) {
			throw new NoDataAvailableException("600", "No Data available");
		}
		return set;
	}

	@Override
	public List<Employee> findParticularRecordsAscsDeatails() {
		List<Employee> list = employeeRepository.findAll();
		if(list.isEmpty()) {
			throw new NoDataAvailableException("600","No data Availble");
		}
		List<Employee> ascrecords = list.stream()
				.sorted((s1, s2) -> s1.getSalary() < s2.getSalary() ? -1 : s2.getSalary() < s1.getSalary() ? 1 : 0)
				.skip(1).limit(4).collect(Collectors.toList());
		return ascrecords;
	}

	@Override
	public List<Employee> findParticularRecordsDscDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<Employee> dscrecords = list.stream()
				.sorted((s1, s2) -> s2.getSalary() < s1.getSalary() ? -1 : s1.getSalary() < s2.getSalary() ? 1 : 0)
				.skip(1).limit(4).collect(Collectors.toList());
		return dscrecords;
	}

	@Override
	public List<String> mapNamesDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<String> names = list.stream().map(s1 -> s1.getName()).sorted().collect(Collectors.toList());
		return names;
		// List<Employee> ascNamesSorted =
		// list.stream().sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList());
		// return ascNamesSorted;
		// List<Employee> dscNamesSorted =
		// list.stream().sorted(Comparator.comparing(Employee::getEmpName).reversed()).collect(Collectors.toList());
		// return dscNamesSorted;
	}

	@Override
	public Map<Character, Integer> findStringOccurenceDeatails() {
		// TODO Auto-generated method stub
		String str = null;
		List<Employee> list = employeeRepository.findAll();
		List<String> names = list.stream().map(s1 -> s1.getName()).sorted().collect(Collectors.toList());
		System.out.println(names);
		for (String string : names) {
			if (string.equals("naveenkumar")) {
				str = "naveenkumar";
				break;
			}

		}
		char[] ch = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (Character char1 : ch) {
			if (map.containsKey(char1)) {
				map.put(char1, map.get(char1) + 1);
			} else {
				map.put(char1, +1);
			}

		}
		System.out.println(map);
		return map;
	}

	@Override
	public Map<Object, List<Employee>> groupBySalaryDeatails() {
		List<Employee> list = employeeRepository.findAll();
		Map<Object, List<Employee>> groupSalaries = list.stream()
				.collect(Collectors.groupingBy(s1 -> s1.getSalary(), TreeMap::new, Collectors.toList()));
		return groupSalaries;
	}

	@Override
	public Map<Object, List<Employee>> groupByNamesDeatails() {
		List<Employee> list = employeeRepository.findAll();
		Map<Object, List<Employee>> groupNames = list.stream()
				.collect(Collectors.groupingBy(s1 -> s1.getName(), TreeMap::new, Collectors.toList()));
		return groupNames;
	}

	@Override
	public Employee findByNameAndDeptNameDeatails(String name, String deptName) {
		Employee list = employeeRepository.findByNameAndDeptName(name, deptName);
		if(list.getName().isEmpty()) {
			throw new NoDataAvailableException("600","No data Availble");
		}
		return list;
	}

	@Override
	public Employee findByEmpIdAndNameAndDeptNameDeatails(int empId, String name, String deptName) {
		Employee list = employeeRepository.findByEmpIdAndNameAndDeptName(empId, name, deptName);
		if(list.getName().isEmpty()) {
			throw new NoDataAvailableException("600","No data Availble");
		}
		return list;
	}

	@Override
	public String firstnonRepeactedCharacterInStringDeatails() {
		String str = null;
		List<Employee> list = employeeRepository.findAll();
		List<String> names = list.stream().map(s1 -> s1.getName()).sorted().collect(Collectors.toList());
		for (String string : names) {
			if (string.equals("naveenkumar")) {
				str = "naveenkumar";
				break;
			}

		}
		String firstnonRepeated = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(s1 -> s1.getValue() == 1).findFirst().get().getKey();
		return firstnonRepeated;
	}

	@Override
	public String firstRepeactedCharacterInStringDeatails() {
		String str = null;
		List<Employee> list = employeeRepository.findAll();
		List<String> names = list.stream().map(s1 -> s1.getName()).sorted().collect(Collectors.toList());
		for (String string : names) {
			if (string.equals("naveenkumar")) {
				str = "naveenkumar";
				break;
			}

		}
		String firstRepeatedCharcater = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(s1 -> s1.getValue() > 1).findFirst().get().getKey();
		return firstRepeatedCharcater;
	}

	@Override
	public List<String> printDublicatesInStringDeatails() {
		String str = null;
		List<Employee> list = employeeRepository.findAll();
		List<String> names = list.stream().map(s1 -> s1.getName()).sorted().collect(Collectors.toList());
		for (String string : names) {
			if (string.equals("naveenkumar")) {
				str = "naveenkumar";
				break;
			}

		}
		List<String> dublicates = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(s1 -> s1.getValue() > 1).map(Map.Entry::getKey)
				.collect(Collectors.toList());
		return dublicates;
	}

	@Override
	public List<String> uniquerecordsInStringDeatails() {
		String str = null;
		List<Employee> list = employeeRepository.findAll();
		List<String> names = list.stream().map(s1 -> s1.getName()).sorted().collect(Collectors.toList());
		for (String string : names) {
			if (string.equals("naveenkumar")) {
				str = "naveenkumar";
				break;
			}

		}
		List<String> uniq = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(s1 -> s1.getValue() == 1).map(Map.Entry::getKey)
				.collect(Collectors.toList());
		return uniq;
	}

	@Override
	public String longestStringDeatails() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		List<String> stringnames = list.stream().map(s1 -> s1.getName()).collect(Collectors.toList());
		String longestString = stringnames.stream()
				.reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();

		return longestString;
	}

	@Override
	public String smallestStringDeatails() {
		List<Employee> list = employeeRepository.findAll();
		List<String> stringnames = list.stream().map(s1 -> s1.getName()).collect(Collectors.toList());
		String smallestString = stringnames.stream()
				.reduce((word1, word2) -> word2.length() > word1.length() ? word1 : word2).get();

		return smallestString;
	}

	@Override
	public List<String> filterDepartmentIdsDeatails() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		List<Integer> deptIds = list.stream().map(s1 -> s1.getDepartmentId()).collect(Collectors.toList());
		List<String> depts = deptIds.stream().map(s1 -> s1 + "").filter(s2 -> s2.startsWith("2"))
				.collect(Collectors.toList());
		return depts;
	}

	@Override
	public String stringReverseJava8Deatails() {
		// TODO Auto-generated method stub
		String str = "SREENIVASARAO";
		String reverse = Arrays.asList(str).stream().map(s -> new StringBuilder(s).reverse().toString())
				.collect(Collectors.toList()).get(0);
		return reverse;
	}

	@Override
	public Employee secondHigestSalaryDeatails() {
		List<Employee> list = employeeRepository.findAll();
		Employee secondHigestSalary = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				.skip(1).findFirst().get();
		return secondHigestSalary;
	}

	@Override
	public Employee secondListSalaryDeatails() {
		List<Employee> list = employeeRepository.findAll();
		Employee secondListSalary = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).skip(1)
				.findFirst().get();
		return secondListSalary;
	}

	@Override
	public List<Employee> indexRangesDeatails(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		List<Employee> ranges = list.subList(fromIndex, toIndex);
		return ranges;
	}

	@Override
	public String joiningNamesDeatails() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		String joinNames = list.stream().map(s1 -> s1.getName()).collect(Collectors.joining(","));
		return joinNames;
	}

	@Override
	public Set<Employee> listToSetCoversion() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		Set<Employee> set = list.stream().collect(Collectors.toSet());
		return set;
	}

	@Override
	public Map<Integer, Employee> listToMapCoversion() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		Map<Integer, Employee> listToMapConversion = list.stream()
				.collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
		return listToMapConversion;
	}

	@Override
	public List<Employee> setToListConversion() {
		List<Employee> list = employeeRepository.findAll();
		Set<Employee> set = list.stream().collect(Collectors.toSet());
		List<Employee> setToList = set.stream().collect(Collectors.toList());
		return setToList;
	}

	@Override
	public Map<Integer, Employee> setToMapConversionDetails() {
		List<Employee> list = employeeRepository.findAll();
		Set<Employee> set = list.stream().collect(Collectors.toSet());
		// TODO Auto-generated method stub
		Map<Integer, Employee> setToMap = set.stream()
				.collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
		return setToMap;
	}

	@Override
	public List<Entry<Integer, Employee>> mapToListConversionDetails() {
		List<Employee> list = employeeRepository.findAll();
		Map<Integer, Employee> listToMapConversion = list.stream()
				.collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
		List<Entry<Integer, Employee>> mapToList = listToMapConversion.entrySet().stream().collect(Collectors.toList());
		return mapToList;
	}

	@Override
	public Set<Entry<Integer, Employee>> mapToSetConversionDetails() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		Map<Integer, Employee> listToMapConversion = list.stream()
				.collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
		Set<Entry<Integer, Employee>> mapToSet = listToMapConversion.entrySet().stream().collect(Collectors.toSet());
		return mapToSet;
	}

}
