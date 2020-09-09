package console_application;

import facade.Facade;

public class Update {
	
	public Update(String name) {
		Facade.start();
		
		try {
			// TODO
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Facade.finish();
	}

	public static void main(String[] args) {
		new Update("Action");
	}

}
