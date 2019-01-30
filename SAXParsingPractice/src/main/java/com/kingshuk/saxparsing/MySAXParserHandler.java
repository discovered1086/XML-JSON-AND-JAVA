package com.kingshuk.saxparsing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.kingshuk.saxparsing.beans.Customer;



public class MySAXParserHandler extends DefaultHandler {

	/**
	 * We need to have a list here because the handler methods 
	 * we have overriden, can't share data among each other as they are
	 * all having void return type. We need to store the data somewhere
	 */
	private List<Customer> customers;
	
	/**
	 * We need another variable here to keep track of
	 * where the parser is located at any given point in time
	 * during the parse process. We'll store the current element
	 * in the string so that we can use that to initialize 
	 * variables inside the customer class
	 */
	private String currentElement = "";
	
	/**
	 * We also need a customer class here to read the data for each customer
	 */
	private Customer customer;

	@Override
	public void startDocument() throws SAXException {
		customers = new ArrayList<>();
	}

	@Override
	public void endDocument() throws SAXException {
	}

	/*
	 * For an xml file without any namespaces and prefixes, the name of the
	 * arguement Will be in the qname arguement
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentElement = qName;
		
		switch (currentElement) {
		case "customers":			
			break;
		case "customer":
			customer = new Customer();
			
			//Now it's time to get the ID of the customer
			customer.setId(Integer.parseInt(attributes.getValue(Customer.ID)));
			
			//Now I need to add the customer to the list
			customers.add(customer);
			break;
		default:
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {		
		//Now here we need to reset the value of the current element so that 
		//we have the latest current element value at all times
		currentElement ="";
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
	}

	public List<Customer> getCustomers(String fileName) {

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

		try {
			SAXParser ourSaxParser = saxParserFactory.newSAXParser();

			ourSaxParser.parse(new File(fileName), this);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return customers;
	}

}
