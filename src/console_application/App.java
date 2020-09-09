package console_application;

import java.util.Scanner;
import java.util.List;
import facade.Facade;
import model.Game;
import model.User;

public class App {
	Scanner keyboard;
	
	public App() {
		keyboard = new Scanner(System.in);
	}
	
	public void startApp() {
		Facade.start();
		
		this.start();
	}
	
	public void closeApp() {
		Facade.finish();
		System.out.print("Fechando aplicação...");
	}
	
	private void start() {
		System.out.println("\n======= Bem vindo(a)! O que deseja fazer? ======="
				+ "\n(1) Logar-se "
				+ "\n(2) Cadastrar-se "
				+ "\n(3) Sair");
		
		System.out.print("\n> ");
		
		String userInput = keyboard.nextLine();
		
		switch(userInput) {
			case "1":
				try {
					System.out.print("\nDigite seu email: ");
					String email = keyboard.nextLine();
					
					System.out.print("Digite sua senha: ");
					String password = keyboard.nextLine();
					
					Facade.login(email, password);
					this.logged();
				} catch(Exception e) {
					System.out.println("\n" + e.getMessage());
				}
				// Return to the first screen
				this.start();
				break;
				
			case "2":
				try {
					System.out.print("\nDigite seu nome: ");
					String name = keyboard.nextLine();
					
					System.out.print("Digite seu email: ");
					String email = keyboard.nextLine();
					
					System.out.print("Digite sua senha: ");
					String password = keyboard.nextLine();
					
					Facade.registerUser(name, email, password);
				}	catch(Exception e) {
					System.out.println("\n" + e.getMessage());
				}
				
				// Return to the first screen
				this.start();
			case "3":
				return;
			default:
				System.out.println("\nEscolha uma opção disponível (start)");
				
				// Return to the first screen
				this.start();
		}
	}
	
	private void logged() {
		User loggedUser = Facade.getLoggedUser();
		
		if(loggedUser == null) {
			return;
		}
		
		String userName = loggedUser.getName();
		String userGames = loggedUser.getLibrary().toString();
		double userWallet = loggedUser.getWallet();
		
		String welcome = String.format("\n======= Olá %s! ======="
				+ "\n Sua carteira: %s"
				+ "\n Seus jogos: %s"
				+ "\n (1) Jogar!"
				+ "\n (2) Adicionar dinheiro"
				+ "\n (3) Comprar jogos"
				+ "\n (4) Logout",
				userName, userWallet, userGames);
		
		System.out.println(welcome);
		System.out.print("\n > ");
		
		String userInput = keyboard.nextLine();
		
		switch(userInput) {
			// Play a game
			case "1":
				return;
				
			// Add money in the wallet
			case "2":
				try {
					System.out.print("\nDigite a quantia: ");
					
					String value = keyboard.nextLine();
					Facade.addMoney(Double.parseDouble(value));
				} catch(Exception e) {
					System.out.println("\n" + e.getMessage());
				}
				
				// Return to the user screen
				this.logged();
				break;
				
			// Buy a game
			case "3":
				List<Game> games = Facade.listAllGames();
				
				System.out.println(String.format("\nJogos disponíveis para compra: %s", games));
				System.out.print("Digite o nome do jogo para comprar: ");
				
				String gameTitle = keyboard.nextLine();
				
				try {					
					Facade.buyGame(gameTitle, loggedUser);
				} catch(Exception e) {
					System.out.println("\n" + e.getMessage());
				}
				
				// Return to the user screen
				this.logged();
				break;
				
			// Logout
			case "4":
				Facade.logout();
				break;
			default:
				System.out.println("\nEscolha uma opção disponível (logged)");
				this.logged();
		}
	}

	public static void main(String[] args) {
		App app = new App();
		app.startApp();
		app.closeApp();
		
		System.out.println("\nAplicação encerrada.");
	}

}
