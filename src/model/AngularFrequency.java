package model;

public class AngularFrequency {

	public double calculate(double springConstant, double mass) {
		return Math.sqrt(springConstant/mass);
	}
	
}
