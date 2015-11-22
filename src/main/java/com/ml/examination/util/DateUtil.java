package com.ml.examination.util;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil {

	private static final String MM_DD_YYYY = "MM/dd/yyyy";

	public static String dateToString(Date date){
		DateTime dt = new DateTime(date);
		DateTimeFormatter fmt = DateTimeFormat.forPattern(MM_DD_YYYY);
		return fmt.print(dt);
	}
	
	public static int getNumberOfDays(Date date, int years){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, years);
		
		Date in10Years = c.getTime();

		return Days.daysBetween(new DateTime(date), new DateTime(in10Years)).getDays();
	}
	
	public static String  getDateIncremented(Date date, int day){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, day);
		
		return dateToString(c.getTime());
	}
}
