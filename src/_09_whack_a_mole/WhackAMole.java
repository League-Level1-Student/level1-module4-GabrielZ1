package _09_whack_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class WhackAMole implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Random ran = new Random();

	Date timeAtStart;

	JButton moleButton;

	int score = 0;
	int misses = 0;

	JButton[] buttonList = new JButton[24];
	JButton buttonPressed;

	public static void main(String[] args) {
		WhackAMole whackAMole = new WhackAMole();
		whackAMole.run();
	}

	public void run() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setTitle("Whack a Mole");

		drawButtons(ran.nextInt(24));

		frame.add(panel);

		frame.setSize(275,320);

		frame.setVisible(true);

	}

	public void drawButtons(int randomNumber) {

		for (int i = 0; i < 24; i++) {
			buttonList[i] = new JButton();
		}

		moleButton = buttonList[randomNumber];
		moleButton.setText("mole!");


		for (int i = 0; i < 24; i++) {
			buttonList[i].addActionListener(this);
			panel.add(buttonList[i]);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//this starts the time on the first click
		if(score == 0 && misses == 0) {
			timeAtStart = new Date();
		}

		buttonPressed = (JButton) e.getSource();

		if(buttonPressed == moleButton) {
			playSound("/Users/GabrielZ1/git/level1-module4-GabrielZ1/src/_09_whack_a_mole/moleSound.wav");
			score ++;
		}
		else {
			misses ++;

			if(misses == 1) {
				speak("You missed");	
			}
			else if(misses == 2) {
				speak("You missed again");
			}
			else if(misses == 3) {
				speak("You missed three times already");	
			}
			else if(misses == 4) {
				speak("Don't miss again");
			}
			else if(misses == 5) {
				speak("Alright, that's enough");
				endGame(timeAtStart, score);
			}

		}

		frame.dispose();

		for (int i = 0; i < 24; i++) {
			panel.remove(buttonList[i]);
		}

		drawButtons(ran.nextInt(24));
		frame.add(panel);
		frame.setSize(275,320);
		frame.setVisible(true);

		if(score == 10) {
			endGame(timeAtStart, score);
		}

	}


	static void speak(String words) {
		if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
			String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
					+ words + "');\"";
			try {
				Runtime.getRuntime().exec( cmd ).waitFor();
			} catch( Exception e ) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec( "say " + words ).waitFor();
			} catch( Exception e ) {
				e.printStackTrace();
			}
		}
	}


	private void endGame(Date timeAtStart, int molesWhacked) { 
		Date timeAtEnd = new Date();

		if(misses != 5) {
			JOptionPane.showMessageDialog(null, "Your whack rate is "
					+ molesWhacked/(((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00))
					+ " moles per second.");
		}

		System.exit(0);

	}


	public static void playSound(String location) {
		try {
			File musicPath = new File(location);

			if(musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			}
			else {
				System.out.println("Can't find file");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
