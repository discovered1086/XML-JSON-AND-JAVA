package com.kingshuk.javaandjson.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "learningResourceCategory")
public class LearningResourceCategoryDTO {

	@JsonProperty(value = "resourceCateoryId", required = false)
	private String resourceCateoryId;

	@JsonProperty(value = "resourceCateoryName", required = false)
	private String resourceCateoryName;

	@JsonProperty(value = "resourceCateoryDescription", required = false)
	private String resourceCateoryDescription;


	@JsonProperty(value = "subCategories", required = false)
	private List<LearningResourceCategoryDTO> subCategories;
	
	@JsonProperty(value = "location", required = false)
	private LearningResourceLocationDTO location;

}
