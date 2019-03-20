package com.scraper.utils;

import org.junit.Test;

public class GoogleVisionApiLabelUtilsTest {

	@Test
	public void shouldWorkProperly() throws Exception {
		System.out.println(GoogleVisionApiLabelUtils
				.detectFaces("https://s3-media1.fl.yelpcdn.com/photo/Cs_moYMnw6D6RnKtvkhbPA/60s.jpg"));
	}

}
