package com.org.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.java.entity.Address;
import com.org.java.entity.Person;
import com.org.java.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/save")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
		Address address1 = addressService.saveAddressDetails(address);
		return new ResponseEntity("Sucessfully saved in to a Db", HttpStatus.CREATED);

	}

	@GetMapping("/findAll")
	public ResponseEntity<Address> findAllAddress() {
		List<Address> emplist = addressService.findAllAddressDetails();
		return new ResponseEntity(emplist, HttpStatus.OK);
		
	}

}
