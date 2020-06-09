package model;

public class Amplitude {
	
	public double calculate(double displacement, double springConstant, double mass, double time, double degree) {
		return displacement / (Math.cos(time * Math.sqrt(springConstant/mass) + degree));
	}
	
}
