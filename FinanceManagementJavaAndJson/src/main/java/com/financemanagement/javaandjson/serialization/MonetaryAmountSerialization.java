package com.financemanagement.javaandjson.serialization;

import java.io.IOException;

import javax.money.MonetaryAmount;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MonetaryAmountSerialization extends JsonSerializer<MonetaryAmount> {

	@Override
	public void serialize(MonetaryAmount value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartObject();
		gen.writeStringField("amount", String.valueOf(value.getNumber().doubleValue()));
		gen.writeStringField("currency",value.getCurrency().getCurrencyCode());
		gen.writeEndObject();
	}

}
