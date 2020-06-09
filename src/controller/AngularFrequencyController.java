package controller;

import javax.swing.JTextField;

import helper.RoundDecimals;
import model.AngularFrequencyFormula;

public class AngularFrequencyController extends Controller {

	public String calculate(JTextField springConstantField, JTextField massField) {
		
		validateEmptyInput(springConstantField, massField);

		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double mass = Double.parseDouble(massField.getText().replace(",", "."));
		
		AngularFrequencyFormula angularFrequencyFormula = new AngularFrequencyFormula();
		double result = RoundDecimals.round(angularFrequencyFormula.calculate(springConstant, mass), 3);
		
		return String.valueOf(result).replace(".", ",");
	}
	
}
