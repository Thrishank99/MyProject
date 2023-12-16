package com.org.java.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	@Id
	@GeneratedValue
	private int pid;
	private String name;
	private int age;
	private long moibble;
	
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * @JoinColumn(name ="fk_person_address")
	 * @JsonBackReference 
	 * private Address address;
	 */
	
	/* @OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL)
	 @JoinColumn(name ="fk_per_add",referencedColumnName = "pid")
	 private List<Address> address;
	 */
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name ="Person_Address_table", joinColumns = { @JoinColumn(name="person_id",referencedColumnName ="pid")},
	inverseJoinColumns = {@JoinColumn(name="address_id",referencedColumnName ="aid")})
	//@JsonManagedReference
	private Set<Address> address;
	
	
	
	
	

}
