package com.Jobberwocky.job.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Jobberwocky.job.converter.ConverterExternalResponse;
import com.Jobberwocky.job.entity.JobOffer;
import com.Jobberwocky.job.exception.JobOfferException;
import com.Jobberwocky.job.model.JobOfferDto;
import com.Jobberwocky.job.service.JobOfferService;

@RestController
@RequestMapping("/offer")
public class JobOfferController {
	
	private static final String URL = "http://localhost:8080/jobs";
	
	@Autowired
	private JobOfferService jobService;
	
	@Autowired
	private RestTemplate restClient;
	
	@PostMapping("/saveJob")
	public ResponseEntity<?> saveJobOffer(@RequestBody JobOffer job) {
		jobService.saveOffer(job);
		return new ResponseEntity<JobOfferDto>(new JobOfferDto(job), HttpStatus.CREATED);
	}
	
	@GetMapping("/job")
	public ResponseEntity<?> findJobOffersByName(@RequestParam String jobName, @RequestParam String country) {
		String jobs;
		if(!country.isEmpty()) {
			jobs = restClient.getForObject(URL+"?name=".concat(jobName).concat("&country=").concat(country), String.class, jobName);
		}else {
			jobs = restClient.getForObject(URL+"?name=".concat(jobName), String.class, jobName);
		}
		
		List<JobOffer> offers = new ArrayList<JobOffer>();
	
		offers = jobService.findJobByName(jobName, country, ConverterExternalResponse.converter(jobs));
		offers.addAll(ConverterExternalResponse.converter(jobs));
		
		return new ResponseEntity<List<JobOfferDto>>(new JobOfferDto().getOffersDto(offers) , HttpStatus.ACCEPTED);
	}
		
	@GetMapping("/jobs")
	public ResponseEntity<?> showAllJobOffers(){
		String jobs =  restClient.getForObject(URL, String.class);
		
		List<JobOffer> Externaloffers = ConverterExternalResponse.converter(jobs);
		List<JobOffer> offers = new ArrayList<JobOffer>();
		offers = jobService.findAll(Externaloffers);
		offers.addAll(Externaloffers);

		return new ResponseEntity<List<JobOfferDto>>(new JobOfferDto().getOffersDto(offers) , HttpStatus.ACCEPTED);
	}
	

}
