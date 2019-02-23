package com.kingshuk.json.jacksonbinding.harnesses;

import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingshuk.json.jacksonbinding.annotations.models.Address;
import com.kingshuk.json.jacksonbinding.annotations.models.Customer;


public class JacksonJsonGetterHarness {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		Customer customer = new Customer();
		customer.setActive(true);
		customer.setAge(32);
		customer.setJoined(new Date());
		
		Address address = new Address();
		address.setCity("Hartford");
		address.setZipCode("06105");
		
		Address address2 = new Address();
		address2.setCity("Buffalo Grove");
		address2.setZipCode("60089");
		
		customer.setAddresses(Arrays.asList(address, address2));
		
		try {
			String jsonValue = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
			
			System.out.println(jsonValue);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
