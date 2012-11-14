package net.clearwaterproject.sys.com;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate {
	private static final String DATE_JP = "yyyy/MM/dd";
	
	public static Date stringToDate(String value) {  
		SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getDateInstance();
	    sdf.applyPattern(DATE_JP);
	    try {  
	        return sdf.parse(value);  
	    } catch (ParseException e) {  
	        return null;  
	    }  
	}  
}
