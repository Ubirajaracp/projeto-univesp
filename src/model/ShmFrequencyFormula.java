package model;

public class ShmFrequencyFormula {
	
	public double calculate(double springConstant, double mass) {
		return 1 / (2*Math.PI) * Math.sqrt(springConstant/mass);
	}
	
}
