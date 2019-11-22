package com.financemanagement.javaandjson.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.financemanagement.javaandjson.enums.TransactionTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionTypeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3478300589711095031L;

	private String transactionTypeCode;

	private TransactionTypeEnum typeOfTransaction;

	private String transactionTypeDefinition;

	@JsonIgnore
	private ZonedDateTime transactionTypeEffectiveDateTime;

	@JsonIgnore
	private ZonedDateTime transactionTypeTerminationDateTime;
	
	private String transactionTypeEffectiveDate;
	
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String transactionTypeTerminationDate;
}
