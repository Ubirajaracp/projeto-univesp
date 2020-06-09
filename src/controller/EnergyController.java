package controller;

import javax.swing.JTextField;

import model.EnergyFormula;


public class EnergyController {

	public String calculate(JTextField springConstantField, JTextField amplitudeField) {
		
		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double amplitude = Double.parseDouble(amplitudeField.getText().replace(",", "."));

		EnergyFormula energyFormula = new EnergyFormula();
		double result = energyFormula.calculate(springConstant, amplitude);
		
		return String.valueOf(result);
	}
	
}
