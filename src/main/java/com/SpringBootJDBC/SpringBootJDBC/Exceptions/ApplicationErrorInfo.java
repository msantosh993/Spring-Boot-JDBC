package com.SpringBootJDBC.SpringBootJDBC.Exceptions;

import java.time.LocalDateTime;

public class ApplicationErrorInfo {
	private LocalDateTime localDateTie;
	private String message;
	private String description;
	public ApplicationErrorInfo(LocalDateTime localDateTie, String message, String description) {
		super();
		this.localDateTie = localDateTie;
		this.message = message;
		this.description = description;
	}
	public LocalDateTime getLocalDateTie() {
		return localDateTie;
	}
	public String getMessage() {
		return message;
	}
	public String getDescription() {
		return description;
	}
}
