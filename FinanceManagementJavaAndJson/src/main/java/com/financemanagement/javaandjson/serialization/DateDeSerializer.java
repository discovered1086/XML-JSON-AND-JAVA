package com.financemanagement.javaandjson.serialization;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DateDeSerializer extends StdDeserializer<ZonedDateTime> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6075745242190327519L;

	protected DateDeSerializer(Class<?> vc) {
		super(vc);
	}

	public DateDeSerializer() {
		this(null);
	}

	@Override
	public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		String dateTime = p.getText();

		LocalDateTime date = LocalDateTime.parse(dateTime, FinanceManagementSerialization.dateFormatter);
		
		System.out.println(date);

		return ZonedDateTime.of(date, ZoneId.systemDefault());
	}

}
