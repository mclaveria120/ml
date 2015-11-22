package com.ml.examination.weather.types;

import java.util.List;

import com.ml.examination.model.Planet;
import com.ml.examination.model.Position;
import com.ml.examination.weather.WeatherName;

public class MaxRainyWeather extends RainyWeather {

	public MaxRainyWeather() {
		super(WeatherName.MAX_RAINY);
	}

	@Override
	public boolean isOnWeatherCondition(List<Planet> planets) {
		return super.isOnWeatherCondition(planets) && isPerimeterMax(planets);
	}

	private boolean isPerimeterMax(List<Planet> planets) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	private void calculateSideLength(List<Planet> planets){
	  	Position a = planets.get(0).getPosition();
		Position b = planets.get(1).getPosition();
		Position c = planets.get(2).getPosition();
		
		double x1 = a.getX(), y1 = a.getY();
		double x2 = b.getX(), y2 = b.getY();
		double x3 = c.getX(), y3 = c.getY();
		
	    double side1 = Math.round(Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2)));
	    double side2 = Math.round(Math.sqrt(Math.pow((x3-x2),2)+Math.pow((y3-y2),2)));
	    double side3 =Math.round( Math.sqrt(Math.pow((x3-x1),2)+Math.pow((y3-y1),2)));
	    double total= Math.round(side1+side2+side3);
	    
	    if(total>6262)System.out.println(side1+":"+side2+":"+side3+"-------------:"+total);
	    
	  }
	
}
