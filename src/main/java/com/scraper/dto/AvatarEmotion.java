package com.scraper.dto;

public class AvatarEmotion {

	private static final String DEFAULT = "VERY_UNLIKELY";

	private String joy;
	private String surprise;
	private String anger;
	private String sorrow;

	public AvatarEmotion() {
		this.joy = DEFAULT;
		this.surprise = DEFAULT;
		this.anger = DEFAULT;
		this.sorrow = DEFAULT;
	}

	public AvatarEmotion(String joy, String surprise, String anger, String sorrow) {
		this.joy = joy;
		this.surprise = surprise;
		this.anger = anger;
		this.sorrow = sorrow;
	}

	public String getJoy() {
		return joy;
	}

	public void setJoy(String joy) {
		this.joy = joy;
	}

	public String getSurprise() {
		return surprise;
	}

	public void setSurprise(String surprise) {
		this.surprise = surprise;
	}

	public String getAnger() {
		return anger;
	}

	public void setAnger(String anger) {
		this.anger = anger;
	}

	public String getSorrow() {
		return sorrow;
	}

	public void setSorrow(String sorrow) {
		this.sorrow = sorrow;
	}

	@Override
	public String toString() {
		return "AvatarEmotion [joy=" + joy + ", surprise=" + surprise + ", anger=" + anger + ", sorrow=" + sorrow + "]";
	}

}
