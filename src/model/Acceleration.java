package model;


public class Acceleration {
	
	public double calculate(double springConstant, double mass, double displacement) {
		return -springConstant/mass * displacement;
	}
	
}