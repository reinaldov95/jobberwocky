package com.Jobberwocky.job.exception;

import java.io.FileReader;
import java.util.Properties;

import org.springframework.http.HttpStatus;

public enum JobOfferEnumException {
	
	CANT_CREATE(1, JobOfferConstantsException.CANT_CREATE, HttpStatus.BAD_REQUEST),
	NOT_FOUND_DATA(2, JobOfferConstantsException.NOT_FOUND_DATA, HttpStatus.NOT_FOUND),
	NOT_HAVE_OFFERS(3,JobOfferConstantsException.NOT_HAVE_OFFERS, HttpStatus.NOT_FOUND);
	
	
	private String message;
	private int code;
	private HttpStatus status;
	
	JobOfferEnumException(int code, String message, HttpStatus status){
		this.code = code;
		this.message = getException(message);
		this.setStatus(status);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public static String getException(String message) {
			
			String messagePropertie = null;
			try {
				
				FileReader reader= new FileReader("src/main/resources/message.exception.properties");
				Properties p=new Properties();
				p.load(reader);
				messagePropertie = p.getProperty(message);
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return messagePropertie;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
