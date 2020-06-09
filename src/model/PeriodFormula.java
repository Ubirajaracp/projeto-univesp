package model;

public class PeriodFormula {
	
	public double calculate(double springConstant, double mass) {
		return 2 * Math.PI * Math.sqrt(mass/springConstant);
	}
	
}
