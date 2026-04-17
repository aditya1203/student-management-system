package com.example.studentmanagement.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
	private boolean success;
	private int status;
	private String errorCode;
	private String message;
	private String path;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timeStamp;
	
	public ErrorResponse() {
		
	}
	
	public ErrorResponse(boolean success,int status,String errorCode,String message,String path,LocalDateTime timeStamp) {
		this.success=success;
		this.status=status;
		this.errorCode=errorCode;
		this.message=message;
		this.path=path;
		this.timeStamp=timeStamp;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
