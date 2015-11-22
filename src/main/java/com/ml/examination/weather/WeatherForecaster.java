package com.ml.examination.weather;

import java.util.Date;
import java.util.List;

import com.ml.examination.model.WeatherConditonDay;

public interface WeatherForecaster {

	public List<WeatherConditonDay>  forecast10yearFromDate(Date date);
	
	public List<WeatherConditonDay>  forecastOnSpecificDay(int day);
	
}
