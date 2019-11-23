package com.financemanagement.javaandjson.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.financemanagement.javaandjson.enums.TransactionTypeEnum;
import com.financemanagement.javaandjson.serialization.DateSerializer;
import com.financemanagement.javaandjson.serialization.DateTimeDeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
/**
 * @param categoryEffectiveDate
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "transactionCategory")
public class CategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7223290830168812286L;

	@JsonProperty(required = true, value = "categoryId")
	private String categoryId;

	@JsonProperty(required = true, value = "categoryName")
	private String categoryName;

	@JsonProperty(required = false, value = "categoryDescription")
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String categoryDescription;

	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	@JsonProperty(required = true, value = "effectiveDate")
	private ZonedDateTime categoryEffectiveDate;

	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	@JsonProperty(required = false, value = "terminationDate")
	private ZonedDateTime categoryTerminationDate;

	@JsonProperty(required = false, value = "transactionType")
	private TransactionTypeEnum categoryTransactionType;

	@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
	private Set<SubCategoryDTO> subCategories;

	public static class CategoryDTOBuilder {

		public CategoryDTOBuilder categoryEffectiveDate(ZonedDateTime categoryEffectiveDate) {
			this.categoryEffectiveDate = categoryEffectiveDate.with(LocalTime.of(00, 00, 00));

			return this;
		}

		public CategoryDTOBuilder categoryTerminationDate(ZonedDateTime categoryTerminationDate) {
			this.categoryTerminationDate = categoryTerminationDate.with(LocalTime.of(00, 00, 00));

			return this;
		}
	}
}
