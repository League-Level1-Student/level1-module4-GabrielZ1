package _10_slot_machine;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SlotMachine implements ActionListener {

	JFrame frame = new JFrame();
	JLabel slot1Label = new JLabel();
	JLabel slot2Label = new JLabel();
	JLabel slot3Label = new JLabel();
	JButton spinButton = new JButton();

	Random ran = new Random();

	int slot1;
	int slot2;
	int slot3;


	public static void main (String [] args) {
		SlotMachine slotMachine = new SlotMachine();
		slotMachine.run();

	}

	public void run() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());


		spinButton.addActionListener(this);
		spinButton.setText("SPIN!");

		frame.add(spinButton);
		frame.pack();

		frame.setVisible(true);

	}

	private JLabel createLabelImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null){
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		frame.remove(slot1Label);
		frame.remove(slot2Label);
		frame.remove(slot3Label);

		slot1 = ran.nextInt(3);
		slot2 = ran.nextInt(3);
		slot3 = ran.nextInt(3);

		if(slot1 == 0) {
			slot1Label = createLabelImage("grape.png");
		}
		else if(slot1 == 1) {
			slot1Label = createLabelImage("lemon.png");
		}
		else if(slot1 == 2) {
			slot1Label = createLabelImage("strawberry.png");
		}


		if(slot2 == 0) {
			slot2Label = createLabelImage("grape.png");
		}
		else if(slot2 == 1) {
			slot2Label = createLabelImage("lemon.png");
		}
		else if(slot2 == 2) {
			slot2Label = createLabelImage("strawberry.png");
		}


		if(slot3 == 0) {
			slot3Label = createLabelImage("grape.png");
		}
		else if(slot3 == 1) {
			slot3Label = createLabelImage("lemon.png");
		}
		else if(slot3 == 2) {
			slot3Label = createLabelImage("strawberry.png");
		}


		frame.add(slot1Label);
		frame.add(slot2Label);
		frame.add(slot3Label);


		frame.pack();


		if(slot1 == slot2 && slot2 == slot3) {
			JOptionPane.showMessageDialog(null, "You win!");
		}

	}

}
