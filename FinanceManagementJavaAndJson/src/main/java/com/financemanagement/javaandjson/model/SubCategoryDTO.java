package com.financemanagement.javaandjson.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7223290830168812286L;

	private String subCategoryId;

	private String subCategoryName;

	private String subCategoryDescription;
	
	@JsonIgnore
	private ZonedDateTime subCategoryEffectiveDateTime;

	@JsonIgnore
	private ZonedDateTime subCategoryTerminationDateTime;

	private String subCategoryEffectiveDate;

	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String subCategoryTerminationDate;

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(subCategoryId).append(subCategoryName).append(subCategoryDescription)
				.append(subCategoryEffectiveDate).append(subCategoryTerminationDate).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SubCategoryDTO) {
			final SubCategoryDTO subCategoryDTO = (SubCategoryDTO) obj;

			boolean subCategoryEquality = new EqualsBuilder().append(this.subCategoryName.trim().toUpperCase(),
					subCategoryDTO.subCategoryName.trim().toUpperCase()).isEquals();

			return (((Objects.nonNull(this.subCategoryId) && Objects.nonNull(subCategoryId))
					&& this.subCategoryId.equals(subCategoryDTO.subCategoryId)) || subCategoryEquality);

		} else {
			return false;
		}
	}

}
