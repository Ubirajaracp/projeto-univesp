package model;

public class ShmFrequency {
	
	public double calculate(double springConstant, double mass) {
		return 1 / (2*Math.PI) * Math.sqrt(springConstant/mass);
	}
	
}
