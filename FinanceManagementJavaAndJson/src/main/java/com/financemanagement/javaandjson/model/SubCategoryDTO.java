package com.financemanagement.javaandjson.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
@JsonRootName(value = "transactionSubCategory")
public class SubCategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7223290830168812286L;

	@JsonProperty(required = true, value = "subCategoryId")
	private String subCategoryId;

	@JsonProperty(required = true, value = "subCategoryName")
	private String subCategoryName;

	@JsonProperty(required = false, value = "subCategoryDescription")
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String subCategoryDescription;

	@JsonProperty(required = true, value = "subCategoryEffectiveDate")
	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	private ZonedDateTime subCategoryEffectiveDate;

	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	@JsonProperty(required = false, value = "subCategoryTerminationDateTime")
	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	private ZonedDateTime subCategoryTerminationDate;

	public static class SubCategoryDTOBuilder {

		public SubCategoryDTOBuilder subCategoryEffectiveDate(ZonedDateTime subCategoryEffectiveDate) {
			this.subCategoryEffectiveDate = subCategoryEffectiveDate.with(LocalTime.of(00, 00, 00));

			return this;
		}

		public SubCategoryDTOBuilder subCategoryTerminationDate(ZonedDateTime subCategoryTerminationDate) {
			this.subCategoryTerminationDate = subCategoryTerminationDate.with(LocalTime.of(00, 00, 00));

			return this;
		}
	}

}
