package com.org.java.relations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Docter {
	@Id
	private int docterId;
	private String name;
	private String department;
	@ManyToMany(mappedBy = "docters",fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Person1> persons;

}
