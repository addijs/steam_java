package model;
import java.util.ArrayList;
import java.util.List;

import model.Game;

public class User {
	private String name;
	private String email;
	private String password;
	private double wallet;
	private List<Game> library;
	
	public User(String name, String email, String pass) {
		this.name = name;
		this.email = email;
		this.password = pass;
		this.wallet = 0;
		this.library = new ArrayList<Game>();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public List<Game> getLibrary() {
		return library;
	}

	public void addGame(Game game) {
		this.library.add(game);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getWallet() {
		return wallet;
	}

	public void addWalletMoney(double amount) {
		this.wallet = this.wallet + amount;
	}
	
	public void debitWalletMoney(double amount) {
		this.wallet = this.wallet - amount;
	}

}
