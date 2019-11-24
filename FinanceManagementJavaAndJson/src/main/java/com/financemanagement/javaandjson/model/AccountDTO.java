package com.financemanagement.javaandjson.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.money.CurrencyUnit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.financemanagement.javaandjson.serialization.CurrencyDeSerialization;
import com.financemanagement.javaandjson.serialization.CurrencySerialization;
import com.financemanagement.javaandjson.serialization.DateTimeDeSerializer;
import com.financemanagement.javaandjson.serialization.DateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "customerAccount")
public class AccountDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1540097108451574865L;

	@JsonProperty(required = true, value = "accountId")
	private String accountId;

	@JsonProperty(required = true, value = "accountNumber")
	private String accountNumber;

	@JsonProperty(required = true, value = "currency")
	@JsonSerialize(using = CurrencySerialization.class)
	@JsonDeserialize(using = CurrencyDeSerialization.class)
	private CurrencyUnit currency;

	@JsonProperty(required = true, value = "accountDescription")
	private String accountDescription;


	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	@JsonProperty(required = true, value = "accountOpenningDate")
	private ZonedDateTime accountOpenningDate;


	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	@JsonProperty(required = false, value = "accountClosingDate")
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private ZonedDateTime accountClosingDate;

}
