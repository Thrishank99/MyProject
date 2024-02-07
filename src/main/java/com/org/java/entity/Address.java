package com.org.java.entity;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	private int aid;
	private String address1;
	private String state;
	private String country;
	private int pin;
	
	/*
	 * @OneToOne(mappedBy ="address")
	 * @JsonManagedReference
	 *  private Person person;
	 */
	@ManyToMany(mappedBy = "address",fetch = FetchType.LAZY)
	//@JsonBackReference
	private Set<Person> person;
}
