package controller;

import javax.swing.JTextField;

import helper.RoundDecimals;
import model.ShmFrequencyFormula;

public class ShmFrequencyController extends Controller {
	
	public String calculate(JTextField springConstantField, JTextField massField) {
		
		validateEmptyInput(springConstantField, massField);

		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double mass = Double.parseDouble(massField.getText().replace(",", "."));
		
		ShmFrequencyFormula shmFrequencyFormula = new ShmFrequencyFormula();
		double result = RoundDecimals.round(shmFrequencyFormula.calculate(springConstant, mass), 3);
		
		return String.valueOf(result).replace(".", ",");
	}
}
