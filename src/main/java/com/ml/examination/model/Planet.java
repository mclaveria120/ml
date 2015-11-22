package com.ml.examination.model;

public  class Planet implements Moveable{

	protected double angularSpeed;
	protected double radius;
	private Position position;
	
	public Planet(double angularSpeed, double radius) {
		super();
		this.angularSpeed = angularSpeed;
		this.radius = radius;
}

	@Override
	public void move(int days) {
		double newAngularSpeed= this.angularSpeed*days;
		
		double x= this.radius*Math.cos(Math.PI*newAngularSpeed/180);
		double y=this.radius*Math.sin(Math.PI*newAngularSpeed/180);
		
		this.setPosition(new Position(Math.round(x), Math.round(y)));
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return this.getPosition().getX()+":"+this.position.getY();
	}
	
}
