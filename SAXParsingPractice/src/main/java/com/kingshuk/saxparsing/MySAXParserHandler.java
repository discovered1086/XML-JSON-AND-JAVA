package com.kingshuk.saxparsing;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.example.model.Customer;

public class MySAXParserHandler extends DefaultHandler {

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
	 * For an xml file without any namespaces and prefixes, the name of the
	 * arguement Will be in the qname arguement
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("Start element: " + qName);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("End element: " + qName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("Characters event");
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
