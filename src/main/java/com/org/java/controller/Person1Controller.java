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

import com.org.java.relations.Person1;
import com.org.java.service.Person1Service;
@RestController
@RequestMapping("/person1")
public class Person1Controller {
	
	@Autowired
	private Person1Service person1Service;
	
	@PostMapping("/save")
	public ResponseEntity<Person1> savePerson(@RequestBody Person1 person1) {
		Person1 person11 = person1Service.savePersonDetails(person1);
		return new ResponseEntity("Sucessfully saved in to a Db", HttpStatus.CREATED);

	}

	@GetMapping("/findAll")
	public ResponseEntity<Person1> findAllPersons() {
		List<Person1> emplist = person1Service.findAllPersonsDetails();
		return new ResponseEntity(emplist, HttpStatus.OK);
		
	}

}
