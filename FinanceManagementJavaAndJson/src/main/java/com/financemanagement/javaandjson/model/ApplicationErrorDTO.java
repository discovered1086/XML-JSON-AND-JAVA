package com.financemanagement.javaandjson.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.financemanagement.javaandjson.enums.ApplicationErrorType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
public class ApplicationErrorDTO implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 995642617560236207L;

	private String errorCode;

	private String httpErrorCode;

	private ApplicationErrorType typeOfError;

	private String errorDefinition;

	private String errorMessage;

	private ZonedDateTime errorTypeEffectiveDate;

	private ZonedDateTime errorTypeTerminationDate;

}
