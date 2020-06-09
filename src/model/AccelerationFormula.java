package model;


public class AccelerationFormula {
	
	public double calculate(double springConstant, double mass, double displacement) {
		return -springConstant/mass * displacement;
	}
	
}