package controller;

import javax.swing.JTextField;

import helper.RoundDecimals;
import model.PeriodFormula;


public class PeriodController extends Controller {
	
	public String calculate(JTextField springConstantField, JTextField massField) {
		
		validateEmptyInput(springConstantField, massField);
		
		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double mass = Double.parseDouble(massField.getText().replace(",", "."));
		
		PeriodFormula periodFormula = new PeriodFormula();
		double result = RoundDecimals.round(periodFormula.calculate(springConstant, mass), 3);
		
		return String.valueOf(result).replace(".", ",");
	}
	
}
