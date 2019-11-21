package com.financemanagement.javaandjson.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.financemanagement.javaandjson.enums.TransactionTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7223290830168812286L;

	private String categoryId;

	private String categoryName;

	private String categoryDesc;

	@JsonIgnore
	private ZonedDateTime categoryEffectiveDateTime;

	@JsonIgnore
	private ZonedDateTime categoryTerminationDateTime;

	private String categoryEffectiveDate;

	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String categoryTerminationDate;

	private TransactionTypeEnum categoryTransactionType;

	@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
	private Set<SubCategoryDTO> subCategorys;

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(categoryId).append(categoryName).append(categoryDesc)
				.append(categoryEffectiveDate).append(categoryTerminationDate).append(categoryTransactionType)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CategoryDTO) {
			final CategoryDTO categoryDTO = (CategoryDTO) obj;

			boolean categoryEquality = new EqualsBuilder()
					.append(this.categoryName.trim().toUpperCase(), categoryDTO.categoryName.trim().toUpperCase())
					.isEquals() && Objects.deepEquals(this.subCategorys, categoryDTO.subCategorys);

			return (((Objects.nonNull(this.categoryId) && Objects.nonNull(categoryId))
					&& this.categoryId.equals(categoryDTO.categoryId)) || categoryEquality);

		} else {
			return false;
		}
	}

}
