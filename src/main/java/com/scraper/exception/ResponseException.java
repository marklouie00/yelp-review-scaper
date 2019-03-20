package com.scraper.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

/**
 * 
 * @author mark.louie.perez
 * @since 3.05.2019
 *
 */

public class ResponseException extends BaseException {

	private static final long serialVersionUID = 1L;

	public static final String ERROR_CODE = "errorCode";
	public static final String ERROR_DESCRIPTION = "errorDescription";

	private String errorCode;
	private String errorMsg;
	private HttpStatus httpStatus;

	private static final Logger LOG = LoggerFactory.getLogger(ResponseException.class);

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public ResponseException(ErrorCodes errorCode) {
		this(errorCode.getKey(), errorCode.getValue(), HttpStatus.BAD_REQUEST);
	}

	public ResponseException(String errorCode, String errorMsg, HttpStatus httpStatus) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.httpStatus = httpStatus;
		LOG.error(String.format("[%s : %s] - [%s : %s]", ERROR_CODE, errorCode, ERROR_DESCRIPTION, errorMsg));
	}

}
