package com.kingshuk.json;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;
import com.kingshuk.json.jacksonbinding.model.Employee;

public class JsonAndJavaTestWithGson {

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
	public void checkGsonAndJsonTest() {
		Gson gson = new Gson();
		
		Employee employee = new Employee("232649","Kingshuk Mukherjee");
		
		String jsonString = gson.toJson(employee);
		
		System.out.println(jsonString);
		
		Employee employee2 = gson.fromJson(jsonString, Employee.class);
		
		assertEquals(employee.getEmployeeId(), employee2.getEmployeeId());
	}

}
