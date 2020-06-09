package model;

public class Force {

	public double calculate(double springConstant, double displacement) {
		return -springConstant * displacement;
	}
	
}
