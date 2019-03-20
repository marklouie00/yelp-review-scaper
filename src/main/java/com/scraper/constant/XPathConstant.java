package com.scraper.constant;

public class XPathConstant {
	public static final String TEST_YELP_URL = "https://www.yelp.com/biz/livestock-restaurant-and-bar-quezon-city";
	public static final String REVIEW_LIST_PATH = "//ul[@class='ylist ylist-bordered reviews']";
	public static final String NAME_PATH = ".//ul[@class='user-passport-info']/li[1]";
	public static final String LOCATION_PATH = ".//ul[@class='user-passport-info']/li[2]";
	public static final String AVATAR_IMG_PATH = ".//img[@class='photo-box-img']/@src";
	public static final String RATING_PATH = ".//img[@class='offscreen']/@alt";
	public static final String RATING_DATE_PATH = ".//span[@class='rating-qualifier']";
	public static final String COMMENT_PATH = ".//p[@lang='en']";
}
