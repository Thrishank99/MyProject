package com.org.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.java.entity.Employee;
import com.org.java.entity.Person;
import com.org.java.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping("/save")
	public ResponseEntity<Person> savePerson(@RequestBody Person person) {
		Person person1 = personService.savePersonDetails(person);
		return new ResponseEntity("Sucessfully saved in to a Db", HttpStatus.CREATED);

	}

	@GetMapping("/findAll")
	public ResponseEntity<Person> findAllPersons() {
		List<Person> emplist = personService.findAllPersonsDetails();
		return new ResponseEntity(emplist, HttpStatus.OK);
		
	}

}
