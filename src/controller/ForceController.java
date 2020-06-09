package controller;

import javax.swing.JTextField;

import model.ForceFormula;


public class ForceController {
	
	public String calculate(JTextField springConstantField, JTextField displacementField) {
		
		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double displacement = Double.parseDouble(displacementField.getText().replace(",", "."));
		
		ForceFormula forceFormula = new ForceFormula();
		double result = forceFormula.calculate(springConstant, displacement);
		
		return String.valueOf(result);
	}
	
}
