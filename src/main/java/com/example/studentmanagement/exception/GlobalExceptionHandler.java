package com.example.studentmanagement.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import jakarta.servlet.http.HttpServletRequest;


// Handles Error Globally 
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String,Object> handleValidationException(
			MethodArgumentNotValidException ex){
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->
          errors.put(error.getField(), error.getDefaultMessage())
			);
	
		Map<String,Object> response=new HashMap<>();
		response.put("Message", "Validation Failde");
		response.put("errors", errors);
		
		return response;
		
	}
	
	//If Duplicate Email Exists
	@ExceptionHandler(ResponseStatusException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleResponseStatusException(ResponseStatusException ex,HttpServletRequest request){
//		Map<String,Object> error=new HashMap<>();
//		error.put("sucess", "false");
//		error.put("status", ex.getStatusCode().value());
//		error.put("error code", ex.getReason().toUpperCase());
//		error.put("message", ex.getReason());
//		error.put("timestamp", LocalDateTime.now());
//		return new ResponseEntity<>(error,ex.getStatusCode());
		ErrorResponse error=new ErrorResponse(
				false,
				ex.getStatusCode().value(),
				"EMAIL_ALREADY_EXISTS",
				"Email Already exists",
				request.getRequestURI(),
				LocalDateTime.now()
				);
		return new ResponseEntity<>(error,ex.getStatusCode());
	}
}