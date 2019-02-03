package com.kingshuk.xmlstringprocessing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.example.dataprovider.DataProvider;

public class XMLStringProcessor {

	public static void main(String[] args) {
		String fileName = DataProvider.DATADIR+"customers.xml";
		
		StringBuilder stringBuilder = new StringBuilder();
		
		try (FileReader fileReader = new FileReader(fileName);){
			
			int content;
			
			/**
			 * The reader reads one character at a time and returns
			 * an integer value. 
			 */
			while ((content = fileReader.read()) !=-1) {
				stringBuilder.append((char)content);
			}
			
			System.out.println(stringBuilder);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
