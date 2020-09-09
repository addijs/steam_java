package model;

public class Status {
	private User user;
	private Game game;
	private String status = "Owned";
	
	public Status(User user, Game game) {
		this.user = user;
		this.game = game;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public Game getGame() {
		return game;
	}
}
