package com.kingshuk.javaandjson.beans;

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
@JsonRootName(value = "learningResource")
public class LearningResourceDTO {

	@JsonProperty(value = "resourceId", required = false)
	private String resourceId;

	@JsonProperty(value = "resourceTitle", required = true)
	private String resourceTitle;

	@JsonProperty(value = "resourceDescription", required = true)
	private String resourceDescription;

	@JsonProperty(value = "resourceType", required = true)
	private LearningResourceCategoryDTO resourceType;
	
	@JsonProperty(value = "resourceNotes", required = false)
	private String resourceNotes;
	
	@JsonProperty(value = "resourceLocation", required = true)
	private String resourceLocation;
	
}
