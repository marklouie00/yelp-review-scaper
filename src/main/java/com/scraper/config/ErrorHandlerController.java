package com.scraper.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scraper.controller.EntityApiResponse;
import com.scraper.exception.ResponseExceptionMessage;

/**
 * 
 * @author mark.louie.perez
 * @since 3.05.2019
 *
 */
@RestController
public class ErrorHandlerController implements ErrorController {

	private final static String ERROR_PATH = "/error";

	@RequestMapping(ERROR_PATH)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EntityApiResponse> handleError(HttpServletResponse response) {
		return ResponseEntity.status(response.getStatus())
				.body(EntityApiResponse.failed(new ResponseExceptionMessage(String.valueOf(response.getStatus()))));
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
