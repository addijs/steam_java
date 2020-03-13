package model;

public class Game {
	private String title;
	private double price;
	private String[] genres;
	private String owner = "";

	public Game(String title, double price, String[] genres) {
		this.title = title;
		this.price = price;
		this.genres = genres;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String[] getGenres() {
		return genres;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
