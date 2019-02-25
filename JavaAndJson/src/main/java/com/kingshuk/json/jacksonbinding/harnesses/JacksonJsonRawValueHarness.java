package com.kingshuk.json.jacksonbinding.harnesses;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingshuk.json.jacksonbinding.model.rawvalue.Customer;




public class JacksonJsonRawValueHarness {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		Customer customer = new Customer();
		customer.setActive(true);
		customer.setAge(32);
		customer.setJoined(new Date());
		
		
		String address = "{\n" + 
				"    \"city\" : \"Hartford\",\n" + 
				"    \"zipCode\" : \"06105\"\n" + 
				"  }";
		
		customer.setAddress(address);
		
		try {
			String jsonValue = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
			
			System.out.println(jsonValue);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
