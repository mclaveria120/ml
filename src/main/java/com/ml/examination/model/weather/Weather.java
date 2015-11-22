package com.ml.examination.model.weather;

import java.util.List;

import com.ml.examination.model.Planet;
import com.ml.examination.model.ecuation.LinearEcuation;

public abstract class Weather {

	private WeatherName name;
	
	public abstract boolean isOnWeatherCondition(List<Planet> planets);
	
	public Weather(WeatherName name) {
		this.name = name;
	}

	protected LinearEcuation getLinearEcuation(Planet planetA, Planet planetB) {
		LinearEcuation linearEcuation = LinearEcuation.buildLinearEcuation(planetA.getPosition(),planetB.getPosition());
		return linearEcuation;
	}
	
	protected boolean isSunOverTheLine(LinearEcuation linearEcuation){
		return linearEcuation.isIntersectingOrigin();
	}
	
	protected boolean arePlanetsOnALine(List<Planet> planets,LinearEcuation linearEcuation) {
		for (Planet planet : planets) {
			if(!this.isPlanetOnTheLine(linearEcuation, planet)){
				return false;
			}
		}
		return true;
	}

	private boolean isPlanetOnTheLine(LinearEcuation linearEcuation, Planet planet){
		   return linearEcuation.isPointOnTheLine(planet.getPosition());
	}
	
	public WeatherName getName() {
		return name;
	}

	public void setName(WeatherName name) {
		this.name = name;
	}
}
