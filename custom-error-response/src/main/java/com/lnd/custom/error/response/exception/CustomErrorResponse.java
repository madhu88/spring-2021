package com.lnd.custom.error.response.exception;

import java.util.Date;

public class CustomErrorResponse {
	
	private Date timeStamp;
	
	private Integer errorCode;
	
	private Integer subErrorCode;
	
	private String details;

	public CustomErrorResponse(Date timeStamp, Integer errorCode, Integer subErrorCode, String details) {
		super();
		this.timeStamp = timeStamp;
		this.errorCode = errorCode;
		this.subErrorCode = subErrorCode;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Integer getSubErrorCode() {
		return subErrorCode;
	}

	public void setSubErrorCode(Integer subErrorCode) {
		this.subErrorCode = subErrorCode;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
}
