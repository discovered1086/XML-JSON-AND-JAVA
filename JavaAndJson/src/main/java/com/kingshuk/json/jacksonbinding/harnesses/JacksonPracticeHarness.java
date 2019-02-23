package com.kingshuk.json.jacksonbinding.harnesses;

import java.io.File;
import java.io.IOException;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingshuk.json.jacksonbinding.model.Customer;

public class JacksonPracticeHarness {

	public static void main(String[] args) throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Customer customer = objectMapper.readValue(new File("data/single-customer.json"), Customer.class);
		
		System.out.println("The customer:\n"+customer);
	}

}
