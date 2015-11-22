package com.ml.examination.model.weather;

import java.util.List;

import com.ml.examination.model.Planet;
import com.ml.examination.model.ecuation.LinearEcuation;

public class OptimalPressureAndTemperaturePeriod extends Weather{
	
	public OptimalPressureAndTemperaturePeriod() {
		super(WeatherName.OPTIMAL_PREASSURE_AND_TEMPERATUREM);
	}

	@Override	
	public boolean isOnWeatherCondition(List<Planet> planets) {
		LinearEcuation linearEcuation = getLinearEcuation(planets.get(0), planets.get(1));
		return this.arePlanetsOnALine(planets,linearEcuation) && !this.isSunOverTheLine(linearEcuation);
	}
}
