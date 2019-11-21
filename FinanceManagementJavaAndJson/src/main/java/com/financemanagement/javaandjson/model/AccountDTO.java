package com.financemanagement.javaandjson.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.financemanagement.javaandjson.enums.Currency;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(exclude = "accountId")
@Builder
@Data
@JsonRootName(value = "customerAccount")
public class AccountDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1540097108451574865L;

	private String accountId;

	private String accountNumber;

	private Currency currency;

	private String accountDescription;
	
	private String accountOpenningDate;
	
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String accountClosingDate;

	@JsonIgnore
	private ZonedDateTime accountOpenningDateTime;

	@JsonIgnore
	private ZonedDateTime accountClosingDateTime;

}
