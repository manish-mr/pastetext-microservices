package com.mr.pastereaderservice.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(PasteNotFoundException.class)
	public void handlePasteNotFound(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.SC_NOT_FOUND);
	}

}
