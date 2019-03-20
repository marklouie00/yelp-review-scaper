package com.scraper.controller;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author mark.louie.perez
 * @since 3.05.2019
 *
 */

public class EntityApiResponse implements Serializable {

	private static final long serialVersionUID = 232278124980305333L;

	private boolean isSuccess;
	private Date date;
	private Object result;

	public static EntityApiResponse success(Object result) {
		return new EntityApiResponse(true, result);
	}

	public static EntityApiResponse failed(Object result) {
		return new EntityApiResponse(false, result);
	}

	public EntityApiResponse() {

	}

	public EntityApiResponse(boolean isSuccess, Object result) {
		this.isSuccess = isSuccess;
		this.date = new Date();
		this.result = result;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ECResponse [isSuccess=" + isSuccess + ", date=" + date + ", result=" + result + "]";
	}

}
