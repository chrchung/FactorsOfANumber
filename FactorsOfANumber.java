import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 

public class FactorsOfANumber extends JApplet implements ActionListener {	
	private int num;
	private String factors; 
	private boolean validArg = true; 
	private JButton submitButton = new JButton ("Submit!");
	private JTextField inputField = new JTextField (2); 
	private JTextArea outputArea = new JTextArea (10, 40); 
	
	public void init() {
		Container content = getContentPane ();
		content.setLayout(new FlowLayout ());
		setSize (500, 210);
		content.setBackground(Color.white);
		content.add (new JLabel ("Compute the factors of"));
		content.add (inputField);
		content.add (new JLabel (".")); 
		content.add (submitButton);
		content.add (outputArea);
		JScrollPane scrollPane = new JScrollPane(outputArea);
		content.add(scrollPane);
		outputArea.setEditable(false);
		submitButton.addActionListener(this);
	}
		
	//checks if input is valid then computes factors 
	public void getFactors (String input) {
		try { 
			num = Integer.parseInt (input);
			factors = calcFactors (num); 
		} catch (Exception e) {
			validArg = false; 
		}
		
		if (factors == ""){
			outputArea.append(num + " has no factors." + "\n");
		}else if (validArg == true) {
			outputArea.append ("Factors of " + num + ": " + factors + "\n"); 
		}else { //invalid input
			outputArea.append("The input must be a natural number. Please try again." + "\n");
		}
		
		
	}
	
	public String calcFactors (int num){
		int max = num/2 + 1; //max number being tested for being a factor of num
		String factors = ""; 
		
		if (num == 0){
			return ""; 
		}else if (num == 1){
			return "1";
		}
		
		factors = "1"; //1 is a factor for any number
		
		for (int i = 2; i <= max; i++){
			if (num % i == 0){
				factors += ", " + i; 
			}
		}

		factors = factors + ", " + num; //any number is a factor of itself
		return factors; 	
	}
	
	
	
	public boolean isInt (String s) {
		try {
			Integer.parseInt (s);
			return true; 
		} catch (Exception e) {
			return false; 
		}
		
	}


	public void actionPerformed(ActionEvent e) {
		String input = inputField.getText();
		getFactors (input);
	}

	

}