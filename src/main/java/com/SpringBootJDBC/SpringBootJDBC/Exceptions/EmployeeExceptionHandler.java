package com.SpringBootJDBC.SpringBootJDBC.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ApplicationErrorInfo> handleEmployeeException(Exception ex, WebRequest request)
			throws Exception {
		ApplicationErrorInfo applicationErrorInfo = new ApplicationErrorInfo(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ApplicationErrorInfo>(applicationErrorInfo, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ApplicationErrorInfo applicationErrorInfo = new ApplicationErrorInfo(LocalDateTime.now(),
				ex.getFieldError().getDefaultMessage(), request.getDescription(false));
		return new ResponseEntity<>(applicationErrorInfo, HttpStatus.BAD_REQUEST);
	}
}
