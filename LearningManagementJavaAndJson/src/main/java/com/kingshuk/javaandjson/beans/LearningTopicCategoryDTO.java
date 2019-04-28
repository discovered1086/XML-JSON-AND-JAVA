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
@JsonRootName(value = "learningTopicCategory")
public class LearningTopicCategoryDTO {

	@JsonProperty(value = "topicCategoryId", required = false)
	private String topicCategoryId;

	@JsonProperty(value = "topicCategoryName", required = true)
	private String topicCategoryName;

	@JsonProperty(value = "topicCategoryDescription", required = true)
	private String topicCategoryDescription;
	
	@JsonProperty(value = "subCategories", required = false)
	private List<LearningTopicCategoryDTO> subCategories;
}
