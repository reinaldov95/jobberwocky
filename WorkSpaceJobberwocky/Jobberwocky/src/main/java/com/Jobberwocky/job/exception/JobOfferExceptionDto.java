package com.Jobberwocky.job.exception;

import java.util.Date;

public class JobOfferExceptionDto {
	
	private Date timestamp = new Date();
	private int code;
	private String detail;
	
	public JobOfferExceptionDto() { }
	
	public JobOfferExceptionDto(int code, String detail) {
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

}
