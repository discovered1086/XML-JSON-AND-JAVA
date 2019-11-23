package com.financemanagement.javaandjson.harnesses;

import java.io.File;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.financemanagement.javaandjson.model.TransactionDTO;

public class TransactionDeSerializationHarness {

	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			TransactionDTO theTransaction = objectMapper.readValue(new File("jsondata/transaction.json"),
					TransactionDTO.class);

			ZonedDateTime transactionDate = theTransaction.getTransactionDate();

			System.out.println(transactionDate);

			//Converting time to another zone
			System.out.println("US time: " + transactionDate.withZoneSameInstant(ZoneId.of("America/New_York")));

			// The time in US time

//			System.out.println(theTransaction.getTransactionDate().getZone().getId());
//
//			System.out.println(theTransaction.getTransactionCategory().getCategoryEffectiveDate());
//
//			System.out.println(theTransaction.getTransactionType().getTransactionTypeEffectiveDate().getZone());
//
//			System.out.println(theTransaction.getTransactionCategory().getCategoryEffectiveDate());
//
//			System.out.println(theTransaction.getTransactionType().getTransactionTypeEffectiveDate().getZone());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
