package model;
import java.util.ArrayList;

import model.Game;

public class User {
	private String name;
	private String email;
	private String password;
	private double wallet;
	private ArrayList<Game> library;
	
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

	public ArrayList<Game> getLibrary() {
		return library;
	}

	public void setLibrary(ArrayList<Game> library) {
		this.library = library;
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

	public void addMoneyWallet(double amount) {
		this.wallet = this.wallet + amount;
	}
	
	public void debitMoneyWallet(double amount) {
		this.wallet = this.wallet - amount;
	}
}
