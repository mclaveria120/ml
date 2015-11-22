package com.ml.examination.ecuation;

import com.ml.examination.model.Position;


public class LinearEcuation implements Function{

	private Constant constant;
	private double coefficient;
	
	
	public LinearEcuation(double coefficient,Constant constant) {
		this.constant = constant;
		this.coefficient = coefficient;
	}


	@Override
	public double evaluate(double value) {
		return  Math.round(this.coefficient*value+constant.evaluate(value));
	}
	
	
	public static LinearEcuation buildLinearEcuation(Position a, Position b){
		
		double x1=a.getX();
		double y1=a.getY();
		
		double x2=b.getX();
		double y2=b.getY();
		
		double slope=Math.round((y2-y1)/(x2-x1));
		
		return new LinearEcuation(slope,new Constant(Math.round(-1*slope*x1+y1)));
	}
	
	public boolean isPointOnTheLine(Position position){
		double y=this.evaluate(position.getX());
		return position.getY()-y==0;
	}
	
	public boolean isIntersectingOrigin(){
		return this.isPointOnTheLine(new Position(0, 0));
	}
	@Override
	public String toString() {
		return this.coefficient+"x"+this.constant.evaluate(0);
	}
	
}
