package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton jokeButton = new JButton();
	JButton punchlineButton = new JButton();


	public static void main(String[] args) {
		ChuckleClicker chuckleClicker = new ChuckleClicker();
		chuckleClicker.makeButtons();

	}

	public void makeButtons() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setTitle("Chuckle Clicker");

		jokeButton.setText("joke");
		punchlineButton.setText("punchline");

		panel.add(jokeButton);
		panel.add(punchlineButton);

		frame.add(panel);

		frame.pack();

		jokeButton.addActionListener(this);
		punchlineButton.addActionListener(this);

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == jokeButton) {
			JOptionPane.showMessageDialog(null, "joke");
		}
		else {
			JOptionPane.showMessageDialog(null, "punchline");
		}


	}


}