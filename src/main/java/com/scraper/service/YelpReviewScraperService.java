package com.scraper.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomAttr;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.scraper.dto.YelpReviewScraper;
import com.scraper.exception.ErrorCodes;
import com.scraper.exception.ResponseException;

import static com.scraper.constant.XPathConstant.*;

/**
 * 
 * @author mark.louie.perez
 * @since 3.05.2019
 *
 */

@Service
public class YelpReviewScraperService {

	private WebClient client = new WebClient();

	private HtmlPage page;

	private static final Logger LOG = LoggerFactory.getLogger(YelpReviewScraperService.class);

	@PostConstruct
	private void initScraper() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
	}

	public List<YelpReviewScraper> findAllReviewList(String url) throws ResponseException {
		LOG.info("Starting scrapping yelp reviews.");
		List<YelpReviewScraper> yrcList = new ArrayList<>();

		try {
			LOG.debug(String.format("Trying to access yelp review from URL : %s", url));
			page = client.getPage(url);
			LOG.debug(String.format("Access successful : %s", url));
		} catch (FailingHttpStatusCodeException e) {
			throw new ResponseException(ErrorCodes.E_0012);
		} catch (MalformedURLException e) {
			throw new ResponseException(ErrorCodes.E_0013);
		} catch (IOException e) {
			throw new ResponseException(ErrorCodes.E_0014);
		}
		LOG.info("Trying to retrieved reviews.");
		HtmlElement ulElement = (HtmlElement) page.getByXPath(REVIEW_LIST_PATH).get(0);

		Iterator<DomElement> item = ulElement.getChildElements().iterator();
		while (item.hasNext()) {
			DomElement ilElement = item.next();
			DomElement name = (DomElement) ilElement.getFirstByXPath(NAME_PATH);
			DomElement location = (DomElement) ilElement.getFirstByXPath(LOCATION_PATH);
			DomAttr img = (DomAttr) ilElement.getFirstByXPath(AVATAR_IMG_PATH);
			DomAttr rating = (DomAttr) ilElement.getFirstByXPath(RATING_PATH);
			DomElement date = (DomElement) ilElement.getFirstByXPath(RATING_DATE_PATH);
			DomElement comment = (DomElement) ilElement.getFirstByXPath(COMMENT_PATH);
			
			if (!ObjectUtils.isEmpty(name)) {
				yrcList.add(new YelpReviewScraper(name.asText(), img.getValue(), location.asText(), date.asText(),
						rating.getValue(), comment.asText()));
			}
		}
		LOG.info("Retrieving done.");
		return yrcList;
	}

}
