package model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private String title;
	private double price;
	private List<Genre> genres;
//	private String owner = "";

	public Game(String title, double price) {
		this.title = title;
		this.price = price;
		this.genres = new ArrayList<>();
	}

//	public void setOwner(String owner) {
//		this.owner = owner;
//	}

	public void setGenres(List<Genre> genre) {
		this.genres = genre;
	}
	
	public List<Genre> getGenres() {
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
	
	@Override
	public String toString() {
		return title;
	}
}
