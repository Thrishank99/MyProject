package com.org.java.relations;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person1 {
	@Id
	@GeneratedValue
	private int personId;
	private String name;
	private int age;
	private long mobbileNumber;
	
	
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "person_pan_fk")
	  private Pancard card;
	  
	  @OneToMany(cascade = CascadeType.ALL)
	  
	  @JoinColumn(name = "person_lap_fk",referencedColumnName = "personId") private
	  List<Laptop> laptop;
	 
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "person1_docter_table",joinColumns={@JoinColumn(name="person_id",referencedColumnName = "personId")}
    ,inverseJoinColumns = {
	@JoinColumn(name="docter_id",referencedColumnName = "docterId")})
	@JsonManagedReference
	private List<Docter> docters;
	

}
