package controller;

import javax.swing.JTextField;

import model.PeriodFormula;


public class PeriodController {
	
	public String calculate(JTextField springConstantField, JTextField massField) {
		
		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double mass = Double.parseDouble(massField.getText().replace(",", "."));
		
		PeriodFormula periodFormula = new PeriodFormula();
		double result = periodFormula.calculate(springConstant, mass);
		
		return String.valueOf(result);
	}
	
}
