package com.financemanagement.javaandjson.serialization;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DateSerializer extends StdSerializer<ZonedDateTime> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8627328455314620304L;

	protected DateSerializer(Class<ZonedDateTime> t) {
		super(t);
	}

	public DateSerializer() {
		this(null);
	}

	@Override
	public void serialize(ZonedDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.truncatedTo(ChronoUnit.SECONDS).format(FinanceManagementSerialization.dateTimeFormatter));
	}

}
