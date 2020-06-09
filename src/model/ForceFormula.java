package model;

public class ForceFormula {

	public double calculate(double springConstant, double displacement) {
		return -springConstant * displacement;
	}
	
}
