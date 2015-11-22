package com.ml.examination.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.ml.examination.dto.Report;
import com.ml.examination.exceptions.InvalidDayException;
import com.ml.examination.model.WeatherConditonDay;

public interface WeatherForecasterService {

	@GET
	@Path("report/{days}")
	 List<WeatherConditonDay> getSpecificDayReport(@PathParam("days")Integer days) throws InvalidDayException;
	
	
	@GET
	@Path("report/")
	Report getReport();
	
	@GET
	@Path("detailed-report/")
	List<WeatherConditonDay> getDetailedReport();
}
