package console_application;

import model.User;

public class Repository {
	private User isLogged;
	
	public Repository() {
		this.isLogged = null;
	}
	
	public User getIsLogged() {
		return this.isLogged;
	}
	
	public void setIsLogged(User user) {
		this.isLogged = user;
	}
}
