package com.org.java.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.java.entity.Person;
import com.org.java.repository.PersonRepository;
import com.org.java.service.PersonService;

@Component
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person savePersonDetails(Person person) {
		// TODO Auto-generated method stub
		return personRepository.save(person);
	}

	@Override
	public List<Person> findAllPersonsDetails() {
		// TODO Auto-generated method stub
	List<Person> list=personRepository.findAll();
		return list;
	}

}
