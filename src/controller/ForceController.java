package controller;

import javax.swing.JTextField;

import helper.RoundDecimals;
import model.ForceFormula;


public class ForceController extends Controller {
	
	public String calculate(JTextField springConstantField, JTextField displacementField) {
		
		validateEmptyInput(springConstantField, displacementField);

		Double springConstant = Double.parseDouble(springConstantField.getText().replace(",", "."));
		Double displacement = Double.parseDouble(displacementField.getText().replace(",", "."));
		
		ForceFormula forceFormula = new ForceFormula();
		double result = RoundDecimals.round(forceFormula.calculate(springConstant, displacement), 3);
		
		return String.valueOf(result).replace(".", ",");
	}
	
}
