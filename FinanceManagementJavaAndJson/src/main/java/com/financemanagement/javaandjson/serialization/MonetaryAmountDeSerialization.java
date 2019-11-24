package com.financemanagement.javaandjson.serialization;

import java.io.IOException;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class MonetaryAmountDeSerialization extends JsonDeserializer<MonetaryAmount> {

	@Override
	public MonetaryAmount deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		JsonNode node = p.getCodec().readTree(p);

		double amount = 0.00;

		if (node.get("amount") != null) {
			amount = node.get("amount").asDouble();
		}

		CurrencyUnit currencyUnit = Monetary.getCurrency("USD");

		if (node.get("currency") != null) {
			currencyUnit = Monetary.getCurrency(node.get("currency").asText());
		}

		return Monetary.getDefaultAmountFactory().setNumber(amount).setCurrency(currencyUnit).create();

	}

}
