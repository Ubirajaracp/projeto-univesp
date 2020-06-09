package model;

public class AngularFrequencyFormula {

	public double calculate(double springConstant, double mass) {
		return Math.sqrt(springConstant/mass);
	}
	
}
