package model;

public class Energy {
	
	public double calculate(double springConstant, double amplitude) {
		return (1.0 / 2.0) * springConstant * Math.pow(amplitude, 2);
	}
	
}
