package controller;

import javax.swing.JTextField;

import helper.RoundDecimals;
import model.AmplitudeFormula;

public class AmplitudeController extends Controller {

	public String calculate(JTextField springConstantField, JTextField massField, JTextField displacementField,
			JTextField degreeField, JTextField timeField) {
		
		validateEmptyInput(springConstantField, massField, displacementField, degreeField, timeField);
		
		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double mass = Double.parseDouble(massField.getText().replace(",", "."));
		Double displacement = Double.parseDouble(displacementField.getText().replace(",", "."));
		Double degree = Double.parseDouble(degreeField.getText().replace(",", "."));
		Double time = Double.parseDouble(timeField.getText().replace(",", "."));
		
		AmplitudeFormula amplitudeFormula = new AmplitudeFormula();
		double result = RoundDecimals.round(amplitudeFormula.calculate(springConstant, displacement, mass, degree, time), 3);
		
		return String.valueOf(result).replace(".", ",");
	}
}
