package model;

public class AmplitudeFormula {
	
	public double calculate(double springConstant, double displacement, double mass, double degree, double time) {
		return displacement / (Math.cos(time * Math.sqrt(springConstant/mass) + degree));
	}
	
}
