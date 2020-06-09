package controller;

import javax.swing.JTextField;

import helper.RoundDecimals;
import model.AccelerationFormula;

public class AccelerationController extends Controller{
	
	public String calculate(JTextField springConstantField, JTextField massField, JTextField displacementField) {
		
		validateEmptyInput(springConstantField, massField, displacementField);

		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double mass = Double.parseDouble(massField.getText().replace(",", "."));
		Double displacement = Double.parseDouble(displacementField.getText().replace(",", "."));
		
		AccelerationFormula accelerationFormula = new AccelerationFormula();
		double result = RoundDecimals.round(accelerationFormula.calculate(springConstant, mass, displacement), 3);
		
		return String.valueOf(result).replace(".", ",");
	}
	
}
