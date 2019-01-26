package com.kingshuk.saxparsing;



import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.example.model.Customer;

public class MySAXParserHandler extends DefaultHandler{
	
	private List<Customer> customers;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start document");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("End document");
	}

	/*
	 *For an xml file without any namespaces and prefixes, the name of the arguement
	 * Will be in the qname arguement 
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("Start element: "+qName);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}
	
	
	public List<Customer> getCustomers(String fileName){
		return customers;
	}
	

}
