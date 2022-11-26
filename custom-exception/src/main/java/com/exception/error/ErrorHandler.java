package com.exception.error;

import java.time.LocalDateTime;

import javax.naming.ServiceUnavailableException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exception.dao.ErrorDetail;

@RestControllerAdvice
public class ErrorHandler{
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<ErrorDetail> nullPointerException(NullPointerException exception, HttpServletRequest request) {
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setDate(LocalDateTime.now());
		errorDetail.setMessage(exception.getLocalizedMessage());
		errorDetail.setPath(request.getServletPath());
		errorDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		errorDetail.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetail);
	}
	
	
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorDetail> methodNotAllowedExceptionCase(HttpRequestMethodNotSupportedException exception, HttpServletRequest request){
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setDate(LocalDateTime.now());
		errorDetail.setMessage(exception.getLocalizedMessage());
		errorDetail.setPath(request.getServletPath());
		errorDetail.setStatus(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
		errorDetail.setStatusCode(HttpStatus.METHOD_NOT_ALLOWED.value());
		return new ResponseEntity<>(errorDetail, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(value = ServiceUnavailableException.class)
	public ResponseEntity<ErrorDetail> serviceNotAvaliable(ServiceUnavailableException exception, HttpServletRequest request){
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setDate(LocalDateTime.now());
		errorDetail.setMessage(exception.getLocalizedMessage());
		errorDetail.setPath(request.getServletPath());
		errorDetail.setStatus(HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase());
		errorDetail.setStatusCode(HttpStatus.SERVICE_UNAVAILABLE.value());
		return new ResponseEntity<>(errorDetail, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ErrorDetail> userNotFoundException(UserNotFoundException exception, HttpServletRequest request){
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setDate(LocalDateTime.now());
		errorDetail.setMessage(exception.getLocalizedMessage());
		errorDetail.setPath(request.getServletPath());
		errorDetail.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
		errorDetail.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorDetail> exception(Exception exception, HttpServletRequest request){
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setDate(LocalDateTime.now());
		errorDetail.setMessage(exception.getLocalizedMessage());
		errorDetail.setPath(request.getServletPath());
		errorDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		errorDetail.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
