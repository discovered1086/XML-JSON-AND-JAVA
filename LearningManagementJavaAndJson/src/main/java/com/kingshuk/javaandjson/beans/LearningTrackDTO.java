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
@JsonRootName(value = "learningTrack")
public class LearningTrackDTO{

	@JsonProperty(value = "trackId", required = false)
	private String trackId;
	
	@JsonProperty(value = "trackTitle", required = true)
	private String trackTitle;
	
	@JsonProperty(value = "trackDescription", required = true)
	private String trackDescription;
	
	@JsonProperty(value = "trackNotes", required = false)
	private String trackNotes;
	
	@JsonProperty(value = "subTracks", required = false)
    private List<LearningTrackDTO> subTracks;
    
	@JsonProperty(value = "learningTopics", required = false)
    private List<LearningTopicDTO> learningTopics;
    
	@JsonProperty(value = "learningResources", required = false)
    private List<LearningResourceDTO> learningResources;
}
