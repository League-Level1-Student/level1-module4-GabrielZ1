package _06_calculator;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculator {

	JFrame frame = new JFrame();

	JTextField input1 = new JTextField();
	JTextField input2 = new JTextField();

	JButton addingButton = new JButton();
	JButton subtractingButton = new JButton();
	JButton multiplyingButton = new JButton();
	JButton dividingButton = new JButton();

	JLabel result = new JLabel();


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


		
		
		

//put button functionality here











		result.setFont(result.getFont().deriveFont(50.0f));
		result.setHorizontalAlignment(JLabel.CENTER);
		//result.setText(answer);   this is going to be to set the final label to the answer


		frame.add(result);

		frame.setSize(400,200);

		frame.setVisible(true);

	}
}
