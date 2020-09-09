package console_application;

import facade.Facade;
import model.Game;
import model.Genre;

public class Register {
	
	public Register(Game obj, String[] array) {
		Facade.start();
	
		try {
			Facade.registerGame(obj, array);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}			
		
		Facade.finish();
	}
	
	public Register(String name, String email, String password) {
		Facade.start();
		
		try {
			Facade.registerUser(name, email, password);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}			
		
		Facade.finish();
	}
	
	public Register(Genre obj) {
		Facade.start();
		
		try {
			Facade.registerGenre(obj);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}			
		
		Facade.finish();
	} 
	
	public static void main(String[] args) {
		
		// Adding genres
		new Register(new Genre("Action"));
		new Register(new Genre("Shooter"));
		new Register(new Genre("Adventure"));
		new Register(new Genre("Casual"));
		new Register(new Genre("Indie"));
		new Register(new Genre("RPG"));
		new Register(new Genre("RTS"));
		new Register(new Genre("Sports"));
		new Register(new Genre("Racing"));
		new Register(new Genre("Simulation"));
		
		// Adding genres
		String[] arrayA = {"Action", "Adventure", "RPG", "Indie"};
		String[] arrayB = {"Action", "Shooter"};
		String[] arrayC = {"Action", "Shooter", "RPG"};
		String[] arrayD = {"Action", "Adventure", "RPG"};
		String[] arrayE = {"Racing", "Sports"};
		String[] arrayF = {"Action", "Shooter", "Casual"};
		String[] arrayG = {"Action", "Adventure", "Shooter"};
		
		// Adding games
		new Register(new Game("CrossCode", 35.25), arrayA);
		new Register(new Game("GTA V", 69.99), arrayB);
		new Register(new Game("Borderlands 3", 119.99), arrayC);
		new Register(new Game("Rainbow Six Siege", 59.99), arrayB);		
		new Register(new Game("Monster Hunter World", 69.99), arrayD);
		new Register(new Game("Final Fantasy XV", 125.00), arrayD);
		new Register(new Game("Rocket League", 36.99), arrayE);
		new Register(new Game("The Surge", 54.99), arrayB);
		new Register(new Game("Garry's Mod", 19.99), arrayF);
		new Register(new Game("Bioshock Infinite", 89.99), arrayG);
		
		// Adding users
		new Register("Adilson","adelso@gmail.com", "123456");
		new Register("Paulo", "paulo@hotmail.com", "abcd");
	}
}
