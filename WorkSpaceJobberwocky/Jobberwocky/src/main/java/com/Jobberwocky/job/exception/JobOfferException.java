package com.Jobberwocky.job.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class JobOfferException extends RuntimeException {

	private static final long serialVersionUID = -1872671146826504480L;
	
	private Date timestamp = new Date();
	private int code;
	private String detail;
	private HttpStatus status;
	
	public JobOfferException() { }
	
	public JobOfferException(JobOfferEnumException enumOfferException) {
		this.code = enumOfferException.getCode();
		this.detail = enumOfferException.getMessage();
		this.setStatus(enumOfferException.getStatus());
	}
	
	public JobOfferException(int code, String detail) {
		this.code = code;
		this.detail = detail;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
