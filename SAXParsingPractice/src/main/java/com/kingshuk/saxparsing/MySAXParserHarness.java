package com.kingshuk.saxparsing;

import java.util.List;

import com.example.dataprovider.DataProvider;
import com.kingshuk.saxparsing.beans.Customer;

public class MySAXParserHarness {

	public static void main(String[] args) {
		String xmlFile = DataProvider.DATADIR+"customers.xml";
		
		System.out.println(xmlFile);
		
		MySAXParserHandler handler = new MySAXParserHandler();
		
		List<Customer> customers = handler.getCustomers(xmlFile);
		
		customers.forEach(customer -> System.out.println("Customer ID: "+customer.getId()));
	}

}
