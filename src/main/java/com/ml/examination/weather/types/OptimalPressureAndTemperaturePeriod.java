package com.ml.examination.weather.types;

import java.util.List;

import com.ml.examination.model.Planet;
import com.ml.examination.model.ecuation.LinearEcuation;
import com.ml.examination.weather.Weather;
import com.ml.examination.weather.WeatherName;

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
