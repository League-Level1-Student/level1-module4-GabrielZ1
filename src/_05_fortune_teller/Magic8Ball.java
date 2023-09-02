package _05_fortune_teller;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.util.Random;

import javax.swing.JOptionPane;

public class Magic8Ball {

	// 1. Make a main method that includes all the steps below….
	public static void main (String [] args) {

		// 2. Make a variable that will hold a random number and put a random number into this variable using "new Random().nextInt(4)"

		int randomNumber = new Random().nextInt(4);

		// 3. Print out this variable

		System.out.println(randomNumber);

		// 4. Get the user to enter a question for the 8 ball

		JOptionPane.showInputDialog("Ask the magic 8 ball a question.");

		// 5. If the random number is 0

		if(randomNumber == 0) {

			// -- tell the user "Yes"
			JOptionPane.showMessageDialog(null, "Yes");

		}
		// 6. If the random number is 1

		if(randomNumber == 1) {

			// -- tell the user "No"
			JOptionPane.showMessageDialog(null, "No");

		}


		// 7. If the random number is 2
		if(randomNumber == 2) {

			// -- tell the user "Maybe you should ask Google?"
			JOptionPane.showMessageDialog(null, "Maybe you should ask google?");

		}

		// 8. If the random number is 3
		if(randomNumber == 3) {

			// -- write your own answer
			JOptionPane.showMessageDialog(null, "Perhaps");

		}


	}
}
