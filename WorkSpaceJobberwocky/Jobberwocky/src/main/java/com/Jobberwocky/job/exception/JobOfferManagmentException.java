package com.Jobberwocky.job.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JobOfferManagmentException {
	
	@ExceptionHandler(JobOfferException.class)
	public ResponseEntity<?> JobOfferException(JobOfferException jobException){
		JobOfferExceptionDto jobExceptionDto = new JobOfferExceptionDto(jobException.getCode(),jobException.getDetail());
		return new ResponseEntity<JobOfferExceptionDto>(jobExceptionDto, jobException.getStatus());
	}

}
