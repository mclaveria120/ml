package com.ml.examination.model.ecuation;

public class Constant implements Function {

	private double coeffciente;
	
	public Constant(double coeffciente) {
		this.coeffciente = coeffciente;
	}

	@Override
	public double evaluate(double value) {
		return this.coeffciente;
	}
}
