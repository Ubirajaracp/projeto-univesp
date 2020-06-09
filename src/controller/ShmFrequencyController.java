package controller;

import javax.swing.JTextField;

import model.ShmFrequencyFormula;

public class ShmFrequencyController {
	
	public String calculate(JTextField springConstantField, JTextField massField) {
		
		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double mass = Double.parseDouble(massField.getText().replace(",", "."));
		
		ShmFrequencyFormula shmFrequencyFormula = new ShmFrequencyFormula();
		double result = shmFrequencyFormula.calculate(springConstant, mass);
		
		return String.valueOf(result);
	}
}
