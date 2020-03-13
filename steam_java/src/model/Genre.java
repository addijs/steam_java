package model;

import java.util.ArrayList;

public class Genre {
	String name;
	ArrayList<Game> games;
	
	public Genre(String name) {
		this.name = name;
		this.games = new ArrayList<Game>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addGame(Game game) {
		games.add(game);
	}
}
