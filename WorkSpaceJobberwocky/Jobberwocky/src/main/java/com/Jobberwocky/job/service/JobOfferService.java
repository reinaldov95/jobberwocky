package com.Jobberwocky.job.service;

import java.util.List;
import java.util.Optional;

import com.Jobberwocky.job.entity.JobOffer;
import com.Jobberwocky.job.exception.JobOfferException;

public interface JobOfferService {
	
	public JobOffer saveOffer(JobOffer job) throws JobOfferException;
	
	public List<JobOffer> findJobByName(String jobName, String country, List<JobOffer> externalOffers) throws JobOfferException;
	
	public List<JobOffer> findAll(List<JobOffer> externalOffers);

}
