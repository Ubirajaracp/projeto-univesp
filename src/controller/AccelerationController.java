package controller;

import javax.swing.JTextField;

import model.AccelerationFormula;

public class AccelerationController {

	public String calculate(JTextField springConstantField, JTextField massField, JTextField displacementField) {
		
		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double mass = Double.parseDouble(massField.getText().replace(",", "."));
		Double displacement = Double.parseDouble(displacementField.getText().replace(",", "."));
		
		AccelerationFormula accelerationFormula = new AccelerationFormula();
		double result = accelerationFormula.calculate(springConstant, mass, displacement);
		
		return String.valueOf(result);
	}
}
