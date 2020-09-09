package console_application;

import model.User;

public class Repository {
	private User userLogged;
	
	public Repository() {
		this.userLogged = null;
	}
	
	public User getUserLogged() {
		return this.userLogged;
	}
	
	public void setUserLogged(User user) {
		this.userLogged = user;
	}
}
