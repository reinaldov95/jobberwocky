package com.Jobberwocky.job.model;

import java.util.ArrayList;
import java.util.List;

import com.Jobberwocky.job.entity.JobOffer;

public class JobOfferDto {

	private String jobName;
	private String companyName;
	private Double salary;
	private String country;
	private String[] skills;
	private String comments;
	
	List<JobOfferDto> offersDto = new ArrayList<JobOfferDto>();

	public JobOfferDto() { }
	
	public JobOfferDto(JobOffer offer) { 
		this.jobName = offer.getJobName();
		this.companyName = offer.getCompanyName();
		this.salary = offer.getSalary();
		this.country = offer.getCountry();
		this.skills = offer.getSkills();
		this.comments = offer.getComments();
	}

	public JobOfferDto(String jobName, String companyName, Double salary, String country, String[] skills,String comments) {
		this.jobName = jobName;
		this.companyName = companyName;
		this.salary = salary;
		this.country = country;
		this.skills = skills;
		this.comments = comments;
	}
	
	public List<JobOfferDto> getOffersDto(List<JobOffer> jobOffers) {
		for(JobOffer offer:jobOffers) {
			JobOfferDto offerDto = new JobOfferDto();
			offerDto.setJobName(offer.getJobName());
			offerDto.setCompanyName(offer.getCompanyName());
			offerDto.setSalary(offer.getSalary());
			offerDto.setCountry(offer.getCountry());
			offerDto.setSkills(offer.getSkills());
			offerDto.setComments(offer.getComments());
			offersDto.add(offerDto);
		}
		return offersDto;
	}
	
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
