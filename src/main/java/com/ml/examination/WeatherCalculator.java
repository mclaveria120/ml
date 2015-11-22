package com.ml.examination;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ml.examination.model.Planet;
import com.ml.examination.model.WeatherConditonDay;
import com.ml.examination.util.DateUtil;
import com.ml.examination.util.DefaultValues;
import com.ml.examination.weather.Weather;
import com.ml.examination.weather.WeatherName;

public class WeatherCalculator {

	
	public List<WeatherConditonDay> forecast10yearFromDate(Date date){
		
		 List<Planet> planets= DefaultValues.getPlanets();
		 List<Weather> weathers= DefaultValues.getWeathers();
		 List<WeatherConditonDay> weatherConditionsDays = new ArrayList<WeatherConditonDay>();
		 
		 int days=DateUtil.getNumberOfDays(date,10);
		
		 for (int i = 0; i <= days; i++) {
			 for (Planet planet : planets) {
				 planet.move(i);
			 }
			 for (Weather weather : weathers) {
				if(weather.isOnWeatherCondition(planets)){
					weatherConditionsDays.add(createWeatherConditionDay(date, i, weather.getName()));
				}
			}
		}
		 
		return weatherConditionsDays;
	}

	private WeatherConditonDay createWeatherConditionDay(Date date, int i,WeatherName name) {
		WeatherConditonDay day = new WeatherConditonDay();
		day.setDay(i);
		day.setInitialDate(date);
		day.setName(name);
		return day;
	}
}
