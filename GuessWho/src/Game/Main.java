package Game;

public class Main {
	/*
	 * The main class that will have the main method
	 * Main method runs: Game starts
	 */
	
	//Main method that calls the GuessWho method
	public static void main(String[] args) {
		GuessWho();
	}
	
	//GuessWho method creates an Overseer o object which starts the game
	public static void GuessWho() {
		Overseer o= new Overseer();
	}
	
}
