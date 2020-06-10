package controller;

import javax.swing.JTextField;

public abstract class Controller {
	
	protected void validateEmptyInput(JTextField... args) {
		
	    for (JTextField input : args) {
			if (input.getText().replaceAll("\\s+","").equals("")) {
			    throw new IllegalArgumentException();
			}
	    }
	    
	}
	
}
