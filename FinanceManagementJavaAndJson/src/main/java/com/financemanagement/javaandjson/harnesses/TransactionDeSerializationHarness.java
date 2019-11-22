package com.financemanagement.javaandjson.harnesses;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.financemanagement.javaandjson.model.TransactionDTO;

public class TransactionDeSerializationHarness {

	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			TransactionDTO theTransaction = objectMapper.readValue(new File("jsondata/transaction.json"),
					TransactionDTO.class);

			System.out.println(theTransaction.getTransactionDate());
			
			System.out.println(theTransaction.getTransactionCategory().getCategoryEffectiveDate());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
