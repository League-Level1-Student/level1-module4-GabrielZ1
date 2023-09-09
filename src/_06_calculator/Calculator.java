package _06_calculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	JFrame frame = new JFrame();

	JTextField input1 = new JTextField();
	JTextField input2 = new JTextField();

	JButton addingButton = new JButton();
	JButton subtractingButton = new JButton();
	JButton multiplyingButton = new JButton();
	JButton dividingButton = new JButton();

	JLabel result = new JLabel();

	double finalAnswer;

	public double add (double num1, double num2) {
		double sum = num1+num2;
		return sum;
	}

	public double subtract (double num1, double num2) {
		double difference = num1-num2;
		return difference;
	}

	public double multiply (double num1, double num2) {
		double product = num1*num2;
		return product;
	}

	public double divide (double num1, double num2) {
		double quotient = num1/num2;
		return quotient;
	}





	public void run() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		input1.setColumns(15);
		input2.setColumns(15);


		addingButton.addActionListener(this);
		subtractingButton.addActionListener(this);
		multiplyingButton.addActionListener(this);
		dividingButton.addActionListener(this);


		addingButton.setText("add");
		subtractingButton.setText("subtract");
		multiplyingButton.setText("multiply");
		dividingButton.setText("divide");


		frame.setLayout(new FlowLayout());

		frame.add(input1);
		frame.add(input2);
		frame.add(addingButton);	
		frame.add(subtractingButton);
		frame.add(multiplyingButton);
		frame.add(dividingButton);




		result.setFont(result.getFont().deriveFont(40.0f));
		result.setHorizontalAlignment(JLabel.CENTER);


		frame.add(result);


		frame.setSize(400,200);

		frame.setVisible(true);

	}

	//this is what is run when a button is clicked

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();

		String input1AsString = input1.getText();
		String input2AsString = input2.getText();

		Double input1AsDouble = Double.parseDouble(input1AsString);
		Double input2AsDouble = Double.parseDouble(input2AsString);


		if(addingButton == buttonPressed) {
			finalAnswer = add(input1AsDouble, input2AsDouble);

		}
		if(subtractingButton == buttonPressed) {
			finalAnswer = subtract(input1AsDouble, input2AsDouble);

		}
		if(multiplyingButton == buttonPressed) {
			finalAnswer = multiply(input1AsDouble, input2AsDouble);

		}
		if(dividingButton == buttonPressed) {
			finalAnswer = divide(input1AsDouble, input2AsDouble);

		}

		String finalAnswerAsString = Double.toString(finalAnswer);

		result.setText(finalAnswerAsString);


	}
}
