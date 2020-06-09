package controller;

import javax.swing.JTextField;

import model.AmplitudeFormula;

public class AmplitudeController {

	public String calculate(JTextField springConstantField, JTextField massField, JTextField displacementField,
			JTextField degreeField, JTextField timeField) {
		
		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double mass = Double.parseDouble(massField.getText().replace(",", "."));
		Double displacement = Double.parseDouble(displacementField.getText().replace(",", "."));
		Double degree = Double.parseDouble(degreeField.getText().replace(",", "."));
		Double time = Double.parseDouble(timeField.getText().replace(",", "."));
		
		AmplitudeFormula amplitudeFormula = new AmplitudeFormula();
		double result = amplitudeFormula.calculate(springConstant, displacement, mass, degree, time);
		
		return String.valueOf(result);
	}
}
