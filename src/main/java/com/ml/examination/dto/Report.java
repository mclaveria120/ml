package com.ml.examination.dto;

import java.io.Serializable;
import java.util.List;

import com.ml.examination.model.WeatherConditonDay;

public class Report implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Period> periods;
	private String initalDate;
	private String maxRainyDay; 
	
	public List<Period> getPeriods() {
		return periods;
	}
	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}
	public String getInitalDate() {
		return initalDate;
	}
	public void setInitalDate(String initalDate) {
		this.initalDate = initalDate;
	}
	public String getMaxRainyDay() {
		return maxRainyDay;
	}
	public void setMaxRainyDay(String maxRainyDay) {
		this.maxRainyDay = maxRainyDay;
	}
}
