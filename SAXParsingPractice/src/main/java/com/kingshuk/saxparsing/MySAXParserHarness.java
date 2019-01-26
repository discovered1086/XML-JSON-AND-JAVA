package com.kingshuk.saxparsing;

import com.example.dataprovider.DataProvider;

public class MySAXParserHarness {

	public static void main(String[] args) {
		String xmlFile = DataProvider.DATADIR+"customers.xml";
		
		System.out.println(xmlFile);
		
		MySAXParserHandler handler = new MySAXParserHandler();
		
		handler.getCustomers(xmlFile);
	}

}
