package com.ml.examination.weather;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ml.examination.model.Planet;
import com.ml.examination.model.WeatherConditonDay;
import com.ml.examination.util.DateUtil;
import com.ml.examination.util.DefaultValues;

@Component
public class DistanceGalaxyWeatherCalculator implements WeatherForecaster{

	public List<WeatherConditonDay> forecast10yearFromDate(Date date){
		 List<WeatherConditonDay> weatherConditionsDays = new ArrayList<WeatherConditonDay>();
		 
		 int days=DateUtil.getNumberOfDays(date,10);
		
		 for (int i = 0; i <= days; i++) {
			 forecastWeaherConditions(weatherConditionsDays, i, DateUtil.getDateIncremented(date,i));
		}
		 
		return weatherConditionsDays;
	}

	public List<WeatherConditonDay>  forecastOnSpecificDay(int day){
		
		List<WeatherConditonDay> weatherConditionsDays = new ArrayList<WeatherConditonDay>();
		
		forecastWeaherConditions(weatherConditionsDays,day,DateUtil.getDateIncremented(new Date(),day));
 	    
		return weatherConditionsDays;
	}
	
	private void forecastWeaherConditions( List<WeatherConditonDay> weatherConditionsDays,int day, String date){
		 List<Planet> planets= DefaultValues.getPlanets();
		 List<Weather> weathers= DefaultValues.getWeathers();
		 
		 for (Planet planet : planets) {
			 planet.move(day);
		 }
		 for (Weather weather : weathers) {
				if(weather.isOnWeatherCondition(planets)){
					weatherConditionsDays.add(createWeatherConditionDay(date, day, weather.getName()));
				}
		 }
	}
	
	private WeatherConditonDay createWeatherConditionDay(String  date, int i,WeatherName name) {
		WeatherConditonDay day = new WeatherConditonDay();
		day.setDay(i);
		day.setDate(date);
		day.setName(name);
		return day;
	}
}
