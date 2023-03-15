package com.Jobberwocky.job.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jobberwocky.job.entity.JobOffer;
import com.Jobberwocky.job.entity.repository.JobOfferRespository;
import com.Jobberwocky.job.exception.JobOfferEnumException;
import com.Jobberwocky.job.exception.JobOfferException;

@Service
public class JobOfferServiceImpl implements JobOfferService {

	@Autowired
	private JobOfferRespository JobRepo;
	
	@Override
	public JobOffer saveOffer(JobOffer job) throws JobOfferException {
		if(null == job.getJobName() || job.getJobName().isEmpty() ||
		   null == job.getCompanyName() || job.getCompanyName().isEmpty() ||
		   null == job.getSalary() ||
		   null == job.getCountry() || job.getCountry().isEmpty() ||
		   null == job.getSkills() || job.getSkills().length == 0) {
			throw new JobOfferException(JobOfferEnumException.CANT_CREATE);
		}
		return JobRepo.save(job);
	}

	@Override
	public List<JobOffer> findJobByName(String jobName, String country, List<JobOffer> externalOffers) throws JobOfferException {
		List<JobOffer> jobOffers = new ArrayList<JobOffer>();
		if(country.isEmpty()) {
			jobOffers = JobRepo.findByJobNameContainingIgnoreCase(jobName);
		}else
			jobOffers = JobRepo.findByJobNameContainingIgnoreCaseAndCountryIgnoreCase(jobName,country);
		
		if(jobOffers.isEmpty() && externalOffers.isEmpty()) {
			throw new JobOfferException(JobOfferEnumException.NOT_FOUND_DATA);
		}
		return jobOffers;
	}

	@Override
	public List<JobOffer> findAll(List<JobOffer> externalOffers) throws JobOfferException {
		List<JobOffer> jobOffers = JobRepo.findAll();
		if(jobOffers.isEmpty() && externalOffers.isEmpty()) {
			throw new JobOfferException(JobOfferEnumException.NOT_HAVE_OFFERS);
		}
		return jobOffers;
	}

}
