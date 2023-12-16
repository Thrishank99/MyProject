package com.org.java.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.java.entity.Address;
import com.org.java.repository.AddressRepository;
import com.org.java.service.AddressService;

@Component
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address saveAddressDetails(Address address) {
		// TODO Auto-generated method stub
		return addressRepository.save(address);
	}

	@Override
	public List<Address> findAllAddressDetails() {
		// TODO Auto-generated method stub
	List<Address> list=addressRepository.findAll();
		return list;
	}

}
