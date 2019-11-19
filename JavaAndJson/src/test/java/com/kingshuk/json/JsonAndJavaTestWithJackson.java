package com.kingshuk.json;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingshuk.json.jacksonbinding.model.Employee;

public class JsonAndJavaTestWithJackson {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Employee employee = new Employee("548799", "Kingshuk Mukherjee");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			String jsonString = objectMapper.writeValueAsString(employee);
			
			Employee result = objectMapper.readValue(jsonString, Employee.class);
			
			assertEquals(result.getEmployeeId(), employee.getEmployeeId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
