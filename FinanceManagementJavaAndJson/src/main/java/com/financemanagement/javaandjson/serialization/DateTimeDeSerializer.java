package com.financemanagement.javaandjson.serialization;

import java.io.IOException;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DateTimeDeSerializer extends StdDeserializer<ZonedDateTime> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3202949066610693761L;

	protected DateTimeDeSerializer(Class<?> vc) {
		super(vc);
	}

	@SuppressWarnings("unused")
	private DateTimeDeSerializer() {
		this(null);
	}

	@Override
	public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

		String dateTime = p.getText();

		return ZonedDateTime.parse(dateTime, FinanceManagementSerialization.dateTimeFormatter);
	}

}
