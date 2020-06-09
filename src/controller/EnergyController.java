package controller;

import javax.swing.JTextField;

import helper.RoundDecimals;
import model.EnergyFormula;


public class EnergyController extends Controller {

	public String calculate(JTextField springConstantField, JTextField amplitudeField) {
		
		validateEmptyInput(springConstantField, amplitudeField);

		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double amplitude = Double.parseDouble(amplitudeField.getText().replace(",", "."));

		EnergyFormula energyFormula = new EnergyFormula();
		double result = RoundDecimals.round(energyFormula.calculate(springConstant, amplitude), 3);
		
		return String.valueOf(result).replace(".", ",");
	}
	
}
