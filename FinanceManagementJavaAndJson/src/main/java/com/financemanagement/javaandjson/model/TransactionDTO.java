package com.financemanagement.javaandjson.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.financemanagement.javaandjson.enums.Currency;
import com.financemanagement.javaandjson.serialization.DateTimeDeSerializer;
import com.financemanagement.javaandjson.serialization.DateTimeSerializer;

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

	private String transactionId;

	private TransactionTypeDTO transactionType;

	private String transactionDescription;

	@JsonProperty(required = true, value = "customerAccount")
	private AccountDTO account;

	private CategoryDTO transactionCategory;

	private Currency transactionCurrency;

	private double transactionAmount;

	// private String transactionDate;

	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	private ZonedDateTime transactionDate;

	private String transactionNotes;

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(transactionId).append(transactionDate).append(transactionCurrency)
				.append(transactionCategory).append(transactionAmount).append(transactionType)
				.append(transactionDescription).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TransactionDTO) {
			final TransactionDTO transactionDTO = (TransactionDTO) obj;

			boolean transactionEquality = new EqualsBuilder()
					.append(this.transactionDate, transactionDTO.transactionDate)
					.append(this.transactionCurrency, transactionDTO.transactionCurrency)
					.append(this.transactionAmount, transactionDTO.transactionAmount)
					.append(this.transactionCategory, transactionDTO.transactionCategory)
					.append(this.account, transactionDTO.account)
					.append(this.transactionDescription.trim().toUpperCase(),
							transactionDTO.transactionDescription.trim().toUpperCase())
					.append(this.transactionType, transactionDTO.transactionType).isEquals();

			return (((Objects.nonNull(this.transactionId) && Objects.nonNull(transactionDTO.transactionId))
					&& this.transactionId.equals(transactionDTO.transactionId)) || transactionEquality);
		} else {
			return false;
		}
	}

}
