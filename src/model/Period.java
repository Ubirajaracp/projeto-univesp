package model;

public class Period {
	
	public double calculate(double springConstant, double mass) {
		return 2 * Math.PI * Math.sqrt(mass/springConstant);
	}
	
}
