package com.scraper.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.scraper.controller.EntityApiResponse;
import com.scraper.exception.ResponseException;
import com.scraper.exception.ResponseExceptionMessage;


/**
 * 
 * @author mark.louie.perez
 * @since 3.05.2019
 *
 */

@ControllerAdvice
public class ExceptionControllerAdvice {

	/**
	 * General Exception handler
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<EntityApiResponse> exception(Exception e) {
		HttpStatus status = HttpStatus.CONFLICT;
		return new ResponseEntity<EntityApiResponse>(
				EntityApiResponse.failed(new ResponseExceptionMessage(String.valueOf(status), e.getLocalizedMessage())),
				status);
	}

	/**
	 * Response Exception handler
	 */
	@ExceptionHandler(ResponseException.class)
	public ResponseEntity<EntityApiResponse> exception(ResponseException e) {
		final HttpStatus status = getStatus(e);
		return new ResponseEntity<>(EntityApiResponse.failed(new ResponseExceptionMessage(e.getErrorCode(), e.getErrorMsg())),
				status);
	}

	/**
	 * Validator Exception handler
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<EntityApiResponse> exception(MethodArgumentNotValidException e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String code = e.getBindingResult().getFieldError().getCode();
		String msg = e.getBindingResult().getFieldError().getDefaultMessage();
		return new ResponseEntity<EntityApiResponse>(EntityApiResponse.failed(new ResponseExceptionMessage(code, msg)), status);
	}

	private HttpStatus getStatus(ResponseException ex) {
		final HttpStatus httpStatus = ex.getHttpStatus();
		final boolean isNull = null == httpStatus;
		return isNull ? HttpStatus.NOT_FOUND : httpStatus;
	}

}
