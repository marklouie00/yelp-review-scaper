package com.scraper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scraper.exception.ResponseException;
import com.scraper.service.YelpReviewScraperService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Yelp Review Scraper")
@RestController
@RequestMapping(value = "/yelpReview")
public class YelpReviewController {

	@Autowired
	private YelpReviewScraperService yrcService;

	@ApiOperation(value = "retrieve list of yelp reviews")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved yelp reviews") })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EntityApiResponse> getTrn(@RequestParam String url) throws ResponseException {
		return new ResponseEntity<EntityApiResponse>(EntityApiResponse.success(yrcService.findAllReviewList(url)),
				HttpStatus.OK);
	}
}
