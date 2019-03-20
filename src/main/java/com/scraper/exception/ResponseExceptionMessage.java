package com.scraper.exception;

/**
 * 
 * @author mark.louie.perez
 * @since 3.05.2019
 *
 */

public class ResponseExceptionMessage {

	private String errorCode;
	private String errorMsg;

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

	public ResponseExceptionMessage(String errorCode) {
		this(errorCode, new String());
	}

	public ResponseExceptionMessage(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "ResponseExceptionMessage [errorCode=" + errorCode + ", errorMsg=" + errorMsg + "]";
	}

}
