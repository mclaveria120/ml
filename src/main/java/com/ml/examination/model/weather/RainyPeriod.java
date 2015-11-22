package com.ml.examination.model.weather;

import java.util.List;

import com.ml.examination.model.Planet;
import com.ml.examination.model.Position;
import com.ml.examination.model.ecuation.LinearEcuation;

public class RainyPeriod extends Weather{

	public RainyPeriod() {
		super(WeatherName.RAINY);
	}

	@Override
	public boolean isOnWeatherCondition(List<Planet> planets) {
		LinearEcuation linearEcuation = getLinearEcuation(planets.get(0), planets.get(1));
		
		return !this.arePlanetsOnALine(planets,linearEcuation) && isInside(planets);
	}

	public boolean isInside(List<Planet> planets){
		Position a = planets.get(0).getPosition();
		Position b = planets.get(1).getPosition();
		Position c = planets.get(2).getPosition();
		
		double x1 = a.getX(), y1 = a.getY();
		double x2 = b.getX(), y2 = b.getY();
		double x3 = c.getX(), y3 = c.getY();
		double x=0,y=0;

		double ABC = Math.abs (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
		double ABP = Math.abs (x1 * (y2 - y) + x2 * (y - y1) + x * (y1 - y2));
		double APC = Math.abs (x1 * (y - y3) + x * (y3 - y1) + x3 * (y1 - y));
		double PBC = Math.abs (x * (y2 - y3) + x2 * (y3 - y) + x3 * (y - y2));

		return  Math.round(ABP) + Math.round(APC)+ Math.round(PBC) == Math.round(ABC);
	}
}
