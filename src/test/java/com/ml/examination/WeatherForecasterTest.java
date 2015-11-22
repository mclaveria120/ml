package com.ml.examination;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.ml.examination.model.Planet;
import com.ml.examination.util.DefaultValues;
import com.ml.examination.weather.Weather;
import com.ml.examination.weather.types.DroughtWeather;

public class WeatherForecasterTest {

	  @Test
	  public void testPlanetsAlign(){
		  List<Planet> planets=DefaultValues.getPlanets();
		 
		 Weather droughtPeriod = new DroughtWeather();
		  
		 for (Planet planet : planets) {
				 planet.move(0);
		 }
		 assertTrue("Not in "+droughtPeriod.getName(), droughtPeriod.isOnWeatherCondition(planets));
	  }

}
