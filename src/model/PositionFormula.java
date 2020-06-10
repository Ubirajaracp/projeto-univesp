package model;

public class PositionFormula {
	
	public double calculate(double amplitude, double angularFrequency, double time, double phaseShift) {
		return amplitude * Math.cos(angularFrequency * time + phaseShift);
	}
	
}