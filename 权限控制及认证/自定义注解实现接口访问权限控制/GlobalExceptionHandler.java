package com.sh.guog.exception;

import javax.security.sasl.AuthenticationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = AuthenticationException.class)
	public String allExceptionHandler(AuthenticationException ex) {
		System.out.println("*********************全局异常捕获*********************");
		return "bad 403";
	}


}
