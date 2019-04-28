package com.kingshuk.javaandjson.harness;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingshuk.javaandjson.beans.LearningResourceCategoryDTO;
import com.kingshuk.javaandjson.beans.LearningResourceDTO;
import com.kingshuk.javaandjson.beans.LearningResourceLocationDTO;
import com.kingshuk.javaandjson.beans.LearningTopicCategoryDTO;
import com.kingshuk.javaandjson.beans.LearningTopicDTO;
import com.kingshuk.javaandjson.beans.LearningTrackDTO;

public class JavaToJsonCodeGenerationHarness2 {

	public static void main(String[] args) {
		LearningTrackDTO trackDTO = new LearningTrackDTO();
		trackDTO.setTrackTitle("Java Programming");
		trackDTO.setTrackDescription("This track is about maintaining learning details" + " for Java");

		LearningResourceCategoryDTO categoryDTO = new LearningResourceCategoryDTO();
		categoryDTO.setResourceCateoryName("Web Article");
		categoryDTO.setLocation(LearningResourceLocationDTO.ONLINE);

		LearningResourceDTO resourceDTO = new LearningResourceDTO();
		resourceDTO.setResourceTitle("Stack overflow site");
		resourceDTO.setResourceDescription("A specific article explains it really well");
		resourceDTO.setResourceType(categoryDTO);
		resourceDTO.setResourceLocation("https://www.stackoverflow.com");

		LearningTopicCategoryDTO topicCategoryDTO = new LearningTopicCategoryDTO();
		topicCategoryDTO.setTopicCategoryName("Subject");
		topicCategoryDTO.setTopicCategoryDescription("A category that is to be treated as a new subject");

		LearningTopicDTO topicDTO = new LearningTopicDTO();
		topicDTO.setTopicTitle("Inheritance in java");
		topicDTO.setTopicDescription("This topic is about learning java inheritance properly");
		topicDTO.setTopicType(topicCategoryDTO);
		
		LearningTopicDTO subTopicDTO = new LearningTopicDTO();
		subTopicDTO.setTopicTitle("Behavior of constructor during inheritance");
		subTopicDTO.setTopicDescription("his topic is about learning the behavior of constructors during inheritance");
		subTopicDTO.setTopicType(topicCategoryDTO);
		
		LearningTrackDTO subTrackDTO = new LearningTrackDTO();
		subTrackDTO.setTrackTitle("Core Java Programming");
		subTrackDTO.setTrackDescription("This track is about maintaining learning details for core Java");
		
		trackDTO.setSubTracks(Arrays.asList(subTrackDTO));
		
		topicDTO.setSubTopics(Arrays.asList(subTopicDTO));

		topicDTO.setLearningResources(Arrays.asList(resourceDTO));

		trackDTO.setLearningTopics(Arrays.asList(topicDTO));

		try(FileOutputStream fileOutputStream = new FileOutputStream(new File("data/learningManagement-2.json"))){
			

			ObjectMapper mapper = new ObjectMapper();

			String jsonValue = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(trackDTO);

			StringReader reader = new StringReader(jsonValue);

			int readValue = 0;

			while ((readValue = reader.read()) != -1) {
				fileOutputStream.write(readValue);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
