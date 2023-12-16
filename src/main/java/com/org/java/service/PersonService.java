package com.org.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.java.entity.Person;

@Service
public interface PersonService {

	Person savePersonDetails(Person person);

	List<Person> findAllPersonsDetails();

}
