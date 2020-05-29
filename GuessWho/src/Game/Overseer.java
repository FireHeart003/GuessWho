package Game;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Overseer {
	/*
	 * This class controls the whole game
	 * Declare all private instance variables 
	 */
	private ArrayList<Characters> characters = new ArrayList<Characters>();//ArrayList of Character Objects
	private String[] name = {"Mario", "Luigi", "Toad", "Boo", "Donkey Kong", "Koopa Troopa", "Goomba", "Monty Mole"};//All the characters that will appear in the game
	private String answer = "";//The actual person the player is trying to guess
	
	//All images that will be used
	private ImageIcon temp = new ImageIcon((getClass().getResource("temp3.png")));
	private ImageIcon mar = new ImageIcon((getClass().getResource("mar.jpg")));
	private ImageIcon peach = new ImageIcon((getClass().getResource("peach.jpg")));
	private ImageIcon bows = new ImageIcon((getClass().getResource("bows.jpeg")));
	private ImageIcon pipe = new ImageIcon((getClass().getResource("pipe.png")));
	private ImageIcon bye = new ImageIcon((getClass().getResource("bye.png")));
	private ImageIcon mario = new ImageIcon((getClass().getResource("mario.png")));
	private ImageIcon mole = new ImageIcon((getClass().getResource("mole.jpg")));
	private ImageIcon goom = new ImageIcon((getClass().getResource("goom.png")));
	private ImageIcon kong = new ImageIcon((getClass().getResource("kong.png")));
	private ImageIcon luigi = new ImageIcon((getClass().getResource("luigi.jpg")));
	private ImageIcon koop = new ImageIcon((getClass().getResource("koop.png")));
	private ImageIcon boo = new ImageIcon((getClass().getResource("boo.jpg")));
	private ImageIcon toad = new ImageIcon((getClass().getResource("toad.png")));
	private ImageIcon yay = new ImageIcon((getClass().getResource("yay.png")));
	private ImageIcon bowse = new ImageIcon((getClass().getResource("bowse.png")));
	private ImageIcon end = new ImageIcon((getClass().getResource("end.png")));
	private ImageIcon married = new ImageIcon((getClass().getResource("married.jpg")));

    
	int turns = 3;//Player only gets 3 tries
	
	/*
	 * Options for the player to choose from
	 */
	private static final String[] START = {"Guess Bowser's character!", "Exit?!?"};//, "2 Player(Player and CPU)"};
	private static final String[] QUESTIONS = {"Have a mustache?", 
			"A turtle?", "SHOWS SHARP jagged teeth?",
			"Have a hat?","Fly without PowerUps?", 
			"Hurt the good guys?", "GUESS","EXIT"};
	private static final String[] GO = {"Let's Go!", "Meh, I will have the Kingdom for myself, bye Mario![Exit]"};


	/*
	 * Constructor where method are called that start and finishes the game
	 */
	public Overseer() {
		start();//Introduction
		guessCPU();//Transition to the game
		answer();//Asking the questions
		guess();//Guessing
	}
	
	/*
	 * Opening introduction to the game/story
	 */
		public void start() {
			Window.msg2("While Peach was getting ready for her wedding...Bowser kidnapped Mario and his friends, and only Princess Peach is left to stop the big bad turtle!"
					+ "\nThis time, it would be up to the Princess to save the Mushroom Kingdom from the hands of Bowser!", peach);
			int x = Window.option1(GO, "Bowser has a trick on his sleeve, a trap...first the labryinth, now this! Entering the Pipe will transport Peach"
					+ "\n to the trap called GuessWho, where she can rescue her friends.", pipe);
			if(x==1) {
				Window.msg2("How could you leave your friends Peach!", bye);
				System.exit(0);
			}
			Window.msg2("Welcome to my BOWSER GuessWho game! \n Guess the correct character with only 3 questions and save your friends, "
					+ "\nlose and become my[Bowser's] wife 4EVERRRRR"
					+ "\n\n If you need to exit, you will leave your friends!", bows);

		}
		
		/*
		 * Method where the characters to guess from are shown and prepares the player to play
		 * Transitions from intorduction to the game 
		 */
		public void guessCPU() {//CPU guesses
			 int x = Window.option1(START, "These are the characters that will be chosen from!", temp);
			 if(x==1) {
				 Window.msg2("How could you leave your friends Peach!", bye);
					System.exit(0);
			 }
			 Window.msg2("Bowser has chosen his character. It is up to you to ask a series of questions"
					+ "\n to find who it is!\n Choose your questions wisely because Bowser only gave you 3 questions that you can ask!!!"
					+ "\n His game, his rules.", bowse);
			characterpick();//Chooses the mystery character
		}
		
		/*
		 * Randomly chooses the mystery character and sets String answer to it
		 */
		public void characterpick() {
	        add();
	        Collections.shuffle(characters);
	        answer = ""+characters.get(0);
	    }
		
		/*
		 * Adds Characters object into the ArrayList
		 * Characters object takes in a String for the name, and 6 booleans 
		 * Booleans used to answer the questions the players choose to ask
		 */
		public void add() {
			characters.add(new Characters("Mario", true, false, false, true, false, false));
			characters.add(new Characters("Luigi", true, false, false, true, false, false));
			characters.add(new Characters("Toad", false, false, false, false,false,false));
			characters.add(new Characters("Boo", false, false, true, false, true, true));
			characters.add(new Characters("Donkey Kong", false, false, false, false, false, false));
			characters.add(new Characters("Koopa Troopa", false, true, false, false,false, true));
			characters.add(new Characters("Goomba", false, false, true, false, false, true));
			characters.add(new Characters("Monty Mole",false, false, false, false, false, true));
			}
		
		/*
		 * The actual guessing game starts
		 * As long as the 3 turns aren't up, the game continues
		 */
		public void answer() {
			while(turns>0) {//while player still has turns
				/*
				 * Displays the number of questions left
				 * Displays the name of each character that is still on the list and those that have been removed are marked with X
				 * Displays the Questions the person can use to guess from
				 */
				int x = Window.option1(QUESTIONS, "Number of QUESTIONS Left: "+ turns +"\nChoose a question to ask!"
						+ "\n\nCharacter CheckList:\n" + name[0] + "\n" +name[1]+ "\n" + name[2] + "\n" + name[3] + "\n"
						+ name[4] + "\n" + name[5] + "\n" + name[6] + "\n" + name[7] + "\n\n Is/Does the character:",temp);
			
				if(x==0) {
					//characters.get(0) is basically the answer/mystery character since the characters ArrayList was shuffled and the first Character was chosen as the mystery person
					boolean b = characters.get(0).get0();//The questions corresponded to the booleans used to create the character
						if(b) {//sets up the list and marks correspondingly to the first boolean parameter of the mystery character
							Window.msg("The character does have a mustache!");
							name[2] = "X";
							name[3] = "X";
							name[4] = "X";
							name[5] = "X";
							name[6] = "X";
							name[7] = "X";
							turns--;
						}
						else {//if the mystery character's first boolean param is false
							Window.msg("The character does not have a mustache!");
							name[0] = "X";
							name[1] = "X";
							turns--;
						}
				}
				if(x==1) {
					boolean b = characters.get(0).get1();
						if(b) {//sets up the list and marks correspondingly to the second boolean parameter of the mystery character
							Window.msg("The character is a turtle!");
							name[0] = "X";
							name[1] = "X";
							name[2] = "X";
							name[3] = "X";
							name[4] = "X";
							name[6] = "X";
							name[7] = "X";
							turns--;
						}
						else {//if the mystery character's second boolean param is false
							Window.msg("The character is not a turtle!");
							name[5]= "X";
							turns--;
						}
				}
				if(x==2) {
					boolean b = characters.get(0).get2();
						if(b) {//sets up the list and marks correspondingly to the third boolean parameter of the mystery character
							Window.msg("The character does have sharp jagged teeth!");
							name[0] = "X";
							name[1] = "X";
							name[2] = "X";
							name[4] = "X";
							name[5] = "X";
							name[7] = "X";
							turns--;
						}
						else {//if the mystery character's third boolean param is false
							Window.msg("The character does not have sharp jagged teeth!");
							name[3] = "X";
							name[6] = "X";
							turns--;
						}
				}
				if(x==3) {
					boolean b = characters.get(0).get3();
						if(b) {//sets up the list and marks correspondingly to the fourth boolean parameter of the mystery character
							Window.msg("The character does wear a hat!");
							name[2] = "X";
							name[3] = "X";
							name[4] = "X";
							name[5] = "X";
							name[6] = "X";
							name[7] = "X";
							turns--;
						}
						else {//if the mystery character's fourth boolean param is false
							Window.msg("The character does not wear a hat!");
							name[0] = "X";
							name[1] = "X";
							turns--;
						}
				}
				if(x==4) {
					boolean b = characters.get(0).get4();
						if(b) {//sets up the list and marks correspondingly to the fifth boolean parameter of the mystery character
							Window.msg("The character can fly without PowerUps!");
							name[0] = "X";
							name[1] = "X";
							name[2] = "X";
							name[4] = "X";
							name[5] = "X";
							name[6] = "X";
							name[7] = "X";
							turns--;
						}
						else {//if the mystery character's fifth boolean param is false
							Window.msg("The character cannot fly without PowerUps!");
							name[3] = "X";
							turns--;
						}
				}
				if(x==5) {
					boolean b = characters.get(0).get5();
						if(b) {//sets up the list and marks correspondingly to the sixth boolean parameter of the mystery character
							Window.msg("The character can hurt the good guys!");
							name[0] = "X";
							name[1] = "X";
							name[2] = "X";
							name[4] = "X";
							turns--;
						}
						else {//if the mystery character's sixth boolean param is false
							Window.msg("The character cannot hurt the good guys!");
							name[3] = "X";
							name[5] = "X";
							name[6] = "X";
							name[7] = "X";
							turns--;
						}
				}
				if(x==6) {//If the player wants to guess already
					turns = 0;//done to end the while loop
				}
				if(x==7) {//EXIT BUTTON
					Window.msg2("How could you leave your friends Peach!", bye);
					System.exit(0);
				}
			}
		}

		/*
		 * Player guesses who the mystery character is and the mystery person is revealed
		 * Ending of the game after everything wraps up is displayed
		 */
		public void guess() {
			//Displays the options: each character's name unless there are "X" on the tile, meaning that they have been eliminated due to questioning as the possible mystery character 
			int x = Window.option1(name, "Choose the MYSTERY CHARACTER! \n The X are characters that were previously ruled out!",temp);
			
			/*
			 * Check for all the wrong characters first
			 */
			
			//if the name chosen is not the answer(characters.get(0).getName0()
			if(name[x] != characters.get(0).getName0()) {
				Window.msg2("You guessed the wrong character!", mar);
				
				/*
				 * Now we check who the mystery character is to display the image
				 */
				if(characters.get(0).getName0().equals("Mario")) {
				Window.msg2("The correct character is: "+characters.get(0).getName0(), mario);
				Window.msg2("You are mine now Peach, muhahahahahaha!", end);
				Window.msg("End Credits:"
						+ "\n Code: ME"
						+ "\n Ideas: Bowser"
						+ "\n Player: Peach"
						+ "\n The End");
				}
				if(characters.get(0).getName0().equals("Luigi")) {
					Window.msg2("The correct character is: "+characters.get(0).getName0(), luigi);
					Window.msg2("You are mine now Peach, muhahahahahaha!", end);
					Window.msg("End Credits:"
							+ "\n Code: ME"
							+ "\n Ideas: Bowser"
							+ "\n Player: Peach"
							+ "\n The End");
					}
				if(characters.get(0).getName0().equals("Toad")) {
					Window.msg2("The correct character is: "+characters.get(0).getName0(), toad);
					Window.msg2("You are mine now Peach, muhahahahahaha!", end);
					Window.msg("End Credits:"
							+ "\n Code: ME"
							+ "\n Ideas: Bowser"
							+ "\n Player: Peach"
							+ "\n The End");

					}
				if(characters.get(0).getName0().equals("Boo")) {
					Window.msg2("The correct character is: "+characters.get(0).getName0(), boo);
					Window.msg2("You are mine now Peach, muhahahahahaha!", end);
					Window.msg("End Credits:"
							+ "\n Code: ME"
							+ "\n Ideas: Bowser"
							+ "\n Player: Peach"
							+ "\n The End");

					}
				if(characters.get(0).getName0().equals("Donkey Kong")) {
					Window.msg2("The correct character is: "+characters.get(0).getName0(), kong);	
					Window.msg2("You are mine now Peach, muhahahahahaha!", end);
					Window.msg("End Credits:"
							+ "\n Code: ME"
							+ "\n Ideas: Bowser"
							+ "\n Player: Peach"
							+ "\n The End");

					}
				if(characters.get(0).getName0().equals("Koopa Troopa")) {
					Window.msg2("The correct character is: "+characters.get(0).getName0(), koop);
					Window.msg2("You are mine now Peach, muhahahahahaha!", end);
					Window.msg("End Credits:"
							+ "\n Code: ME"
							+ "\n Ideas: Bowser"
							+ "\n Player: Peach"
							+ "\n The End");

					}
				if(characters.get(0).getName0().equals("Goomba")) {
					Window.msg2("The correct character is: "+characters.get(0).getName0(), goom);
					Window.msg2("You are mine now Peach, muhahahahahaha!", end);
					Window.msg("End Credits:"
							+ "\n Code: ME"
							+ "\n Ideas: Bowser"
							+ "\n Player: Peach"
							+ "\n The End");

					}
				if(characters.get(0).getName0().equals("Monty Mole")) {
					Window.msg2("The correct character is: "+characters.get(0).getName0(), mole);
					Window.msg2("You are mine now Peach, muhahahahahaha!", end);
					Window.msg("End Credits:"
							+ "\n Code: ME"
							+ "\n Ideas: Bowser"
							+ "\n Player: Peach"
							+ "\n The End");
					}
			}
			/*
			 * We've checked for every wrong character input by the player
			 * If the if statement above is not true, we go to this else statement
			 * The person guessed it right and END CREDITS roll in!
			 */
			else {
				Window.msg2("What! You guessed the right character! You have made the impossible possible...How could this be..."
						+ "\nPrincess Peach saved her friends!!!", yay);
				Window.msg2("End Credits:"
						+ "\n Code: ME"
						+ "\n Ideas: Bowser"
						+ "\n Player: Peach"
						+ "\n You actually did it!!! You deserve a mushrooms", married);
			}
		}
}
