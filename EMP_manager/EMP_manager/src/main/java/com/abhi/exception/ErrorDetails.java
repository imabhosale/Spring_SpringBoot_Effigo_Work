package com.abhi.exception;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorDetails {
	private int status;
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ErrorDetails(int status, String message) {
        this.status = status;
        this.message = message;
    }

	
}
