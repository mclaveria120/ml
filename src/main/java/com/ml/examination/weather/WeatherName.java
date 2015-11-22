package com.ml.examination.weather;

public enum WeatherName {

	RAINY("Lluvioso"),
	DROUGHT("Sequia"),
	MAX_RAINY("Pico de lluvias"),
	OPTIMAL_PREASSURE_AND_TEMPERATURE("Condiciones Optimas de Presion y Temperatura");
		
	private final String name;
	
	private WeatherName(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}
}
