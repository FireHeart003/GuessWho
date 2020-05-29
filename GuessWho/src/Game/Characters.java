package Game;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
public class Characters {

	/*
	 * Declare all private variables
	 * Each private instance variable is used as an attribute for each character
	 * Their values for each character will be used to determine the mystery character that is chosen in the OVERSEER class
	 */
	private String name;
	private boolean mustache;
	private boolean turtle;
	private boolean teeth;
	private boolean hat;
	private boolean fly;
	private boolean hurt;

	/*
	 * Constructor setting all the private instance variables to the corresponding parameters
	 */
	public Characters(String n, boolean m, boolean t,boolean sharp,boolean hat1,boolean f,boolean friend1) {
		name = n;
		mustache = m;
		turtle = t;
		teeth = sharp;
		hat = hat1;
		fly = f;
		hurt = friend1;
	}
	/*
	 * Getters for each attribute to compare with player input
	 */
	
	//Getter for the name
		public String getName0() {
			return name;
		}
		
		//Getter for whether the character has a mustache attribute
		public boolean get0() {
			return mustache;
		}
		
		//Getter for whether the character is a turtle or not
		public boolean get1() {
			return turtle;
		}
		
		//Getter for whether the character has sharp jagged teeth
		public boolean get2() {
			return teeth;
		}
		
		//Getter for whether the character wears a hat
		public boolean get3() {
			return hat;
		}
		
		//Getter for whether the character flies without power ups
		public boolean get4() {
			return fly;
		}
		
		//Getter for whether the character can hurt the good guys
		public boolean get5() {
			return hurt;
		}
	}

