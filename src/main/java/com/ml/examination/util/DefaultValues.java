package com.ml.examination.util;

import java.util.ArrayList;
import java.util.List;

import com.ml.examination.model.Planet;
import com.ml.examination.weather.Weather;
import com.ml.examination.weather.types.DroughtWeather;
import com.ml.examination.weather.types.MaxRainyWeather;
import com.ml.examination.weather.types.OptimalPressureAndTemperatureWeather;
import com.ml.examination.weather.types.RainyWeather;

public class DefaultValues {

	public static List<Weather> getWeathers(){
		 List<Weather> weathers= new ArrayList<>();
		 
		 weathers.add(new DroughtWeather());
		 weathers.add(new OptimalPressureAndTemperatureWeather());
		 weathers.add(new RainyWeather());
		 weathers.add(new MaxRainyWeather());
		 
		 return weathers;
	}
	
	public static List<Planet> getPlanets(){
		 List<Planet> planets= new ArrayList<Planet>();
		 
		 planets.add(new Planet(-1,500));
		 planets.add(new Planet(-3,2000));
		 planets.add(new Planet(5,1000));
		 
		 return planets;
	}
}
