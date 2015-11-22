package com.ml.examination.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ml.examination.dto.Period;
import com.ml.examination.dto.Report;
import com.ml.examination.exceptions.InvalidDayException;
import com.ml.examination.model.WeatherConditonDay;
import com.ml.examination.services.WeatherForecasterService;
import com.ml.examination.util.DateUtil;
import com.ml.examination.weather.DistanceGalaxyWeatherCalculator;
import com.ml.examination.weather.WeatherForecaster;
import com.ml.examination.weather.WeatherName;


@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class WeatherForecasterServiceImpl implements WeatherForecasterService {
	
	
	@Autowired
	WeatherForecaster weatherForecaster;
	
	@Override
	public List<WeatherConditonDay> getSpecificDayReport(Integer days) throws InvalidDayException {
		if(days<0){
			throw new InvalidDayException();
		}
		return weatherForecaster.forecastOnSpecificDay(days);
		
	}

	@Override
	public Report getReport() {
		
		Report report = new Report();
		List<Period> periods = new ArrayList<Period>();
	
		Date initialDate = new Date();
		
		List<WeatherConditonDay> weatherConditionDays = weatherForecaster.forecast10yearFromDate(initialDate);
		
		periods.add(getPeriod(weatherConditionDays, WeatherName.DROUGHT));
		periods.add(getPeriod(weatherConditionDays, WeatherName.RAINY));
		periods.add(getPeriod(weatherConditionDays, WeatherName.OPTIMAL_PREASSURE_AND_TEMPERATURE));
		
		report.setPeriods(periods);
		report.setInitalDate(DateUtil.dateToString(initialDate));
		report.setMaxRainyDay(getMaxRainyDay(weatherConditionDays));
		return report;
		
	}

	@Override
	public List<WeatherConditonDay> getDetailedReport() {
		DistanceGalaxyWeatherCalculator weatherCalculator = new DistanceGalaxyWeatherCalculator();
		
		Date initialDate = new Date();
		
		List<WeatherConditonDay> weatherConditionDays = weatherCalculator.forecast10yearFromDate(initialDate);
		
		return weatherConditionDays;
	}
	
	private Period getPeriod(List<WeatherConditonDay> weatherConditionDays, WeatherName name){
		Period period = new Period();
		period.setName(name.getName());
		int quantity=0;
		
		for (WeatherConditonDay weatherConditonDay : weatherConditionDays) {
			if(name.equals(weatherConditonDay.getName())){
				quantity++;
			}
		}
		period.setQuantity(quantity);
		return period;
	}
	
	private String getMaxRainyDay(List<WeatherConditonDay> weatherConditionDays){
		for (WeatherConditonDay weatherConditonDay : weatherConditionDays) {
			if(WeatherName.MAX_RAINY.equals(weatherConditonDay.getName())){
				 return weatherConditonDay.getDay()+"";
			}
		}
		return "";
	}
}
