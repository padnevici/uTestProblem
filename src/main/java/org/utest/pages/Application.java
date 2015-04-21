package org.utest.pages;

public class Application {
	private long reviewsCount = 0;
	private double rating = 0.0;
	private String name = "";

	public long getReviews() {
		return reviewsCount;
	}

	public void setReviews(long reviews) {
		this.reviewsCount = reviews;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
