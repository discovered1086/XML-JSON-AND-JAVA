package com.financemanagement.javaandjson.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.money.MonetaryAmount;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.financemanagement.javaandjson.serialization.DateTimeDeSerializer;
import com.financemanagement.javaandjson.serialization.DateTimeSerializer;
import com.financemanagement.javaandjson.serialization.MonetaryAmountDeSerialization;
import com.financemanagement.javaandjson.serialization.MonetaryAmountSerialization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
@JsonRootName(value = "transaction")
@JsonPropertyOrder(value = { "transactionId", "transactionDescription", "transactionCurrency", "transactionAmount",
		"transactionType", "transactionDate" }, alphabetic = true)
public class TransactionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7817135024822644549L;

	@JsonProperty(required = true, value = "transactionId")
	private String transactionId;

	@JsonProperty(required = true, value = "transactionType")
	private TransactionTypeDTO transactionType;

	@JsonProperty(required = true, value = "transactionDescription")
	private String transactionDescription;

	@JsonProperty(required = true, value = "customerAccount")
	private AccountDTO account;

	@JsonProperty(required = true, value = "transactionCategory")
	private CategoryDTO transactionCategory;

	/*
	 * @JsonProperty(required = true, value = "transactionCurrency") private
	 * Currency transactionCurrency;
	 * 
	 * @JsonProperty(required = true, value = "transactionAmount") private double
	 * transactionAmount;
	 */

	// @JsonProperty(required = true, value = "transactionAmount")
	@JsonSerialize(using = MonetaryAmountSerialization.class)
	@JsonDeserialize(using = MonetaryAmountDeSerialization.class)
	private MonetaryAmount transactionAmount;

	// private String transactionDate;

	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	@JsonProperty(required = true, value = "transactionDate")
	private ZonedDateTime transactionDate;

	@JsonProperty(required = false, value = "transactionNotes")
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String transactionNotes;

}
