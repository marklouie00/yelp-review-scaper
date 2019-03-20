package com.scraper.dto;

/**
 * 
 * @author mark.louie.perez
 * @since 3.05.2019
 *
 */

public class YelpReviewScraper {

	private String author;
	private String img;
	private AvatarEmotion avatarEmotions;
	private String location;
	private String date;
	private String rating;
	private String comment;

	public YelpReviewScraper() {

	}

	public YelpReviewScraper(String author, String img, AvatarEmotion avatarEmotions, String location, String date,
			String rating, String comment) {
		super();
		this.author = author;
		this.img = img;
		this.avatarEmotions = avatarEmotions;
		this.location = location;
		this.date = date;
		this.rating = rating;
		this.comment = comment;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public AvatarEmotion getAvatarEmotions() {
		return avatarEmotions;
	}

	public void setAvatarEmotions(AvatarEmotion avatarEmotions) {
		this.avatarEmotions = avatarEmotions;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "YelpReviewScraper [author=" + author + ", img=" + img + ", avatarEmotions=" + avatarEmotions
				+ ", location=" + location + ", date=" + date + ", rating=" + rating + ", comment=" + comment + "]";
	}

}
