package controller;

import javax.swing.JTextField;

import helper.RoundDecimals;
import model.PositionFormula;

public class PositionController extends Controller {

	public String calculate(JTextField amplitudeField, JTextField angularFrequencyField, JTextField timeField, JTextField phaseShiftField) {
		
		validateEmptyInput(amplitudeField, angularFrequencyField, timeField, phaseShiftField);
		
		Double amplitude = Double.parseDouble(amplitudeField.getText().replace(",", "."));
		Double angularFrequency = Double.parseDouble(angularFrequencyField.getText().replace(",", "."));
		Double time = Double.parseDouble(timeField.getText().replace(",", "."));
		Double phaseShift = Double.parseDouble(phaseShiftField.getText().replace(",", "."));
		
		PositionFormula positionFormula = new PositionFormula();
		double result = RoundDecimals.round(positionFormula.calculate(amplitude, angularFrequency, time, phaseShift), 3);
		
		return String.valueOf(result).replace(".", ",");
	}
}
