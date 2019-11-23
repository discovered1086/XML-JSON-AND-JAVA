package com.financemanagement.javaandjson.harnesses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.financemanagement.javaandjson.enums.Currency;
import com.financemanagement.javaandjson.enums.TransactionTypeEnum;
import com.financemanagement.javaandjson.model.AccountDTO;
import com.financemanagement.javaandjson.model.CategoryDTO;
import com.financemanagement.javaandjson.model.TransactionDTO;
import com.financemanagement.javaandjson.model.TransactionTypeDTO;

public class TransactionTestHarness {

	public static void main(String[] args) {
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:MM:SS a zzz");
		
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

		TransactionTypeDTO transactionTypeDTO = TransactionTypeDTO.builder().transactionTypeCode("BLLPYMNT")
				.transactionTypeDefinition("Bill payment")
				.transactionTypeEffectiveDate(ZonedDateTime.now().format(formatter))
				.typeOfTransaction(TransactionTypeEnum.EXPENSE)
				.build();

		CategoryDTO categoryDTO = CategoryDTO.builder().categoryId("CTGRY12").categoryName("Credit card bill")
				.categoryDescription("Bill payment for credit card").categoryTransactionType(TransactionTypeEnum.EXPENSE)
				.categoryEffectiveDate(ZonedDateTime.now()).build();

		AccountDTO accountDTO = AccountDTO.builder().accountId("ACCT290").accountNumber("07181610046040")
				.accountDescription("HDFC Bank account").accountOpenningDate(ZonedDateTime.now().format(formatter))
				.currency(Currency.INR).build();

		TransactionDTO transactionDTO = TransactionDTO.builder().transactionCurrency(Currency.INR)
				.transactionDate(ZonedDateTime.now()).transactionId("TRN0098789")
				.transactionAmount(20.30).transactionCategory(categoryDTO).transactionType(transactionTypeDTO)
				.account(accountDTO)
				.transactionDescription("Citi credit card bill payment").build();

		try (FileOutputStream fileOutputStream = new FileOutputStream(new File("jsondata/transaction.json"))) {
			ObjectMapper objectMapper = new ObjectMapper();

			String jsonValue = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(transactionDTO);

			StringReader stringReader = new StringReader(jsonValue);

			int readValue = 0;

			while ((readValue = stringReader.read()) != -1) {
				fileOutputStream.write(readValue);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
