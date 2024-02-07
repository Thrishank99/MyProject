package com.org.java.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.java.entity.Person;

@Repository
public interface TestRepository extends CrudRepository<Person, Integer>{

}
