package com.org.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.java.relations.Person1;

@Repository
public interface Person1Repository extends JpaRepository<Person1, Integer>{
}