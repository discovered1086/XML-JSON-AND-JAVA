package com.kingshuk.javaandjson.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "learningTopic")
public class LearningTopicDTO{

	@JsonProperty(value = "topicId", required = false)
	private String topicId;

	@JsonProperty(value = "topicTitle", required = true)
	private String topicTitle;

	@JsonProperty(value = "topicDescription", required = true)
	private String topicDescription;
	
	@JsonProperty(value = "topicNotes", required = false)
	private String topicNotes;

	@JsonProperty(value = "topicType", required = false)
	private LearningTopicCategoryDTO topicType;
	
	@JsonProperty(value = "learningResources", required = false)
	private List<LearningResourceDTO> learningResources;
	
	@JsonProperty(value = "subTopics", required = false)
	private List<LearningTopicDTO> subTopics;
}
