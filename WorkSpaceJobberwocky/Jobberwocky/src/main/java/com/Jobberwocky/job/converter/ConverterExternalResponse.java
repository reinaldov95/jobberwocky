package com.Jobberwocky.job.converter;

import java.util.ArrayList;
import java.util.List;

import com.Jobberwocky.job.entity.JobOffer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class ConverterExternalResponse {
	
	public static List<JobOffer> converter(String externalResponse) {
		List<JobOffer> jobsOffers = new ArrayList<JobOffer>();
		List<String> skillOffers = new ArrayList<String>();
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode node;
		
		try {
			node = (ArrayNode)mapper.readTree(externalResponse);
			for(JsonNode offerNode: node) {
				for(int i = 0; i < offerNode.size(); i++) {
					JobOffer jobsOffer = new JobOffer();
					jobsOffer.setJobName(offerNode.get(i).asText());
					jobsOffer.setSalary(offerNode.get(i+1).asDouble());
					jobsOffer.setCountry(offerNode.get(i+2).asText());
					ArrayNode nodeSkills = (ArrayNode) offerNode.get(3);
					for(int x = 0; x < nodeSkills.size(); x++) {
						skillOffers.add(nodeSkills.get(x).asText());
						jobsOffer.setSkills(skillOffers.toArray(new String[x]));
					}
					skillOffers.clear();
					jobsOffers.add(jobsOffer);
					break;
				}				
			}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jobsOffers;
	}

}
