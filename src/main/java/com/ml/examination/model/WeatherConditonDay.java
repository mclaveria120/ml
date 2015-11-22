package com.ml.examination.model;

import java.io.Serializable;

import com.ml.examination.weather.WeatherName;

public class WeatherConditonDay implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String date;
	private WeatherName name;
	private int day;
	
	public WeatherName getName() {
		return name;
	}
	public void setName(WeatherName name) {
		this.name = name;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
