package com.org.java.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.org.java.relations.Person1;

@Service
public interface Person1Service {
	Person1 savePersonDetails(Person1 person1);

	List<Person1> findAllPersonsDetails();

}
