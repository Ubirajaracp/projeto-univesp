package controller;

import javax.swing.JTextField;

import model.AngularFrequencyFormula;

public class AngularFrequencyController {

	public String calculate(JTextField springConstantField, JTextField massField) {
		
		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double mass = Double.parseDouble(massField.getText().replace(",", "."));
		
		AngularFrequencyFormula angularFrequencyFormula = new AngularFrequencyFormula();
		double result = angularFrequencyFormula.calculate(springConstant, mass);
		
		return String.valueOf(result);
	}
	
}
