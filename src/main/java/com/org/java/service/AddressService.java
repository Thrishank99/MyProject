package com.org.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.java.entity.Address;
@Service
public interface AddressService {

	Address saveAddressDetails(Address address);

	List<Address> findAllAddressDetails();

}
