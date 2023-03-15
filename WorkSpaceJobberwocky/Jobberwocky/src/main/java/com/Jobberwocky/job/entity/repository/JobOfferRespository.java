package com.Jobberwocky.job.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Jobberwocky.job.entity.JobOffer;

public interface JobOfferRespository extends JpaRepository<JobOffer, Integer> {
	
	public List<JobOffer> findByJobNameContainingIgnoreCaseAndCountryIgnoreCase(@Param("nameOffer") String jobName, @Param("country") String country);
	
	public List<JobOffer> findByJobNameContainingIgnoreCase(@Param("nameOffer") String jobName);
	
}
