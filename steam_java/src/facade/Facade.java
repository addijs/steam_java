package facade;

import console_application.Repository;
import dao.DAO;
import dao.DAO_Game;
import dao.DAO_Genre;
import dao.DAO_User;
import model.Game;
import model.Genre;
import model.User;

public class Facade {
	private static Repository repo = new Repository();
	private static DAO_Game daoGame = new DAO_Game();
	private static DAO_User daoUser = new DAO_User();
	private static DAO_Genre daoGenre = new DAO_Genre();
	
	public static void start() {
		DAO.open();
	}
	
	public static void finish() {
		DAO.close();
	}
	
	public static void registerGame(Game obj) throws Exception {
		DAO.begin();
		String gameTitle = obj.getTitle();
		
		Game g = daoGame.read(gameTitle);
		if(g != null) {
			DAO.rollback();
			throw new Exception(String.format("This game has already been registered: %s", gameTitle));
		}

		for(String x: obj.getGenres()) {
			Genre genre = daoGenre.read(x);
			if(genre == null) {
				DAO.rollback();
				throw new Exception(
						String.format("The genre %s does not exists. %s wasn't registered.", x, gameTitle)
					);
			}
			genre.addGame(obj);
		}
		
		daoGame.create(obj);
		DAO.commit();
		System.out.println(String.format("The game was registered successfully.", gameTitle));
	}
	
	public static User findUser (String name) throws Exception {
		User user = daoUser.read(name);
		
		if(user != null) {
			DAO.rollback();
			throw new Exception(String.format("This user already exists: %s", name));
		}
		
		return user;
	}
	
	public static void registerUser(User obj) throws Exception {
		DAO.begin();
		
		findUser(obj.getName());
		daoUser.create(obj);	
		DAO.commit();
		System.out.println("The user was registered successfully.");
	}
	
	public static void registerGenre(Genre obj) throws Exception {
		DAO.begin();
		String genreName = obj.getName();
		
		Genre genre = daoGenre.read(genreName);
		
		if(genre != null) {
			DAO.rollback();
			throw new Exception(String.format("This genre already exists: %s", genreName));
		}
		
		daoGenre.create(obj);	
		DAO.commit();
		System.out.println("The genre was registered successfully.");
	}
	
	public static void login(String name, String password) throws Exception {
		DAO.begin();
		
		User user = findUser(name);
		if(password == user.getPassword()) {
			repo.setIsLogged(user);
		}
		
		throw new Exception("The password is wrong. Try again.");
	}
	
	public static void logout() {
		repo.setIsLogged(null);
	}
	
	public static void addMoney(double value) throws Exception {
		User user = repo.getIsLogged(); 
		
		if(user == null) {
			throw new Exception("You need to be logged to execute this action.");
		}
		
		user.addMoneyWallet(value);
	}
}
