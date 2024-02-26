package com.org.java.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.java.entity.Person;
import com.org.java.relations.Person1;
import com.org.java.repository.Person1Repository;
import com.org.java.repository.PersonRepository;
import com.org.java.service.Person1Service;
import com.org.java.service.PersonService;

@Component
public class Person1ServiceImpl implements Person1Service{
	
	@Autowired
	private Person1Repository personRepository1;

	@Override
	public Person1 savePersonDetails(Person1 person1) {
		// TODO Auto-generated method stub
		return personRepository1.save(person1);
	}

	@Override
	public List<Person1> findAllPersonsDetails() {
		// TODO Auto-generated method stub
	List<Person1> list=personRepository1.findAll();
		return list;
	}

	

}