package net.clearwaterproject.sys.com;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ComDateFormat {

	private static final String DATE_PATTERN1 = "yyyy/MM/dd";
	 
	private ComDateFormat(){
	  //	
	}
	
	/*DATE_PATTERN1 に変換*/
	public static Date toDateFormat1(String str) {
	    Date date = null;
	    try {
	        SimpleDateFormat sdf = new SimpleDateFormat();
	        sdf.applyPattern(DATE_PATTERN1);
	        sdf.setLenient(false); //厳密な解析
	        date = sdf.parse(str);
	    } catch (java.text.ParseException e) {
	        System.out.println(str + " cannot be parsed.");
	    }
	    return date;
	}
	
}
